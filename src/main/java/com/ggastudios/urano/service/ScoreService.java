package com.ggastudios.urano.service;

import com.ggastudios.urano.bean.ScoreBean;
import com.ggastudios.urano.entities.ScoreEntity;
import com.ggastudios.urano.exception.ScoreException;
import com.ggastudios.urano.exception.UranoException;
import com.ggastudios.urano.exception.code.ScoreCodeMessage;
import com.ggastudios.urano.repository.ScoreRepository;
import com.ggastudios.urano.utils.Constanst;
import com.ggastudios.urano.utils.MappersEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ScoreService extends BaseService{

    @Autowired
    private MappersEntity<ScoreBean, ScoreEntity> mappersEntity;

    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AppService appService;

    private ScoreEntity save(ScoreEntity entity){
        log.debug("[save] - **inicio**" );
        if (entity.getId() == null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constanst.DATE_FORMAT_PATTERN);
            String fecha = simpleDateFormat.format(Calendar.getInstance().getTime());
            entity.setDateUpdate(fecha);
            entity.setAttempt( 1 );
        }else{
            entity.setDateLastAttempt(entity.getDateUpdate());
            entity.setAttempt(entity.getAttempt() + 1 );
        }
        log.debug("[save] - **final**" );
        return scoreRepository.save(entity);
    }

    public ScoreBean insert(ScoreBean bean) throws UranoException {
        log.debug("[insert] - **inicio**" );

        if (!appService.exist(bean.getApplication())){
            throw new ScoreException(ScoreCodeMessage.APP_NOT_FOUND);
        }
        if (!userService.exist(bean.getUser())){
            throw new ScoreException(ScoreCodeMessage.USER_NOT_FOUND);
        }

        int attempt = scoreRepository.countByApplicationAndUserAndLevelEquals(bean.getApplication(),bean.getUser(),bean.getLevel());
        ScoreEntity entity;
        if (attempt == 1){
            entity = scoreRepository.findByApplicationAndUserAndLevelEquals(bean.getApplication(),bean.getUser(),bean.getLevel());
        }else if (attempt == 0){
            entity = mappersEntity.map(bean,ScoreEntity.class);
        }else{
            throw new ScoreException(ScoreCodeMessage.MULTISCORE);
        }

        ScoreEntity entityResponse = this.save(entity);
        log.debug("[insert] - **final**" );
        return mappersEntity.map(entityResponse,ScoreBean.class);
    }

    public List<ScoreBean> getTop(String application,int level,int page,int pageSize){
        log.debug("[getTop] - **inicio**" );
        Comparator<ScoreBean> scoreBeanComparator = Comparator.
                comparing(ScoreBean::getScore)
                .thenComparing(ScoreBean::getDateUpdate,Comparator.reverseOrder());

        List<ScoreBean> beans = scoreRepository
                .findAllByApplicationAndLevelOrderByScoreDesc(application,level, PageRequest.of(page,pageSize))
                .stream()
                .map(e -> mappersEntity.map(e,ScoreBean.class))
                .sorted(scoreBeanComparator.reversed())
                .collect(Collectors.toList());

        log.debug("[getTop] - **final**" );
        return beans;
    }

    public List<ScoreBean> getPrevious(String application, int level, long score,int page,int pageSize) {
        log.debug("[getPrevious] - **inicio**" );
        List<ScoreEntity> entities = scoreRepository.
                findAllByApplicationAndLevelAndScoreIsGreaterThanEqualOrderByScoreAsc(application,level,score,PageRequest.of(page,pageSize));
        if (entities.size() < pageSize){
            entities.addAll(
                    scoreRepository.findAllByApplicationAndLevelAndScoreIsLessThanOrderByScoreDesc(application,level,score,PageRequest.of(page,pageSize - entities.size())));
        }

        Comparator<ScoreBean> scoreComparator = Comparator
                .comparing(ScoreBean::getScore)
                .thenComparing(ScoreBean::getDateUpdate);

        List<ScoreBean> response = entities.stream()
                .map(e -> mappersEntity.map(e,ScoreBean.class))
                .sorted(scoreComparator.reversed())
                .collect(Collectors.toList());
        log.debug("[getPrevious] - **final**" );
        return response;
    }
}
