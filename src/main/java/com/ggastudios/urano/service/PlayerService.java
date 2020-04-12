package com.ggastudios.urano.service;

import com.ggastudios.urano.bean.PlayerBean;
import com.ggastudios.urano.entities.PlayerEntity;
import com.ggastudios.urano.exception.*;
import com.ggastudios.urano.exception.code.AppCodeMessage;
import com.ggastudios.urano.exception.code.PlayerCodeMessage;
import com.ggastudios.urano.repository.PlayerRepository;
import com.ggastudios.urano.utils.Constanst;
import com.ggastudios.urano.utils.MappersEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerService extends BaseService{

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private AppService appService;

    @Autowired
    private MappersEntity<PlayerBean, PlayerEntity> mapEntity;

    private PlayerEntity savePlayer(PlayerEntity playerEntity){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constanst.DATE_FORMAT_PATTERN);
        String fecha = simpleDateFormat.format(Calendar.getInstance().getTime());
        if (playerEntity.getId() == null){
            playerEntity.setDateStart(fecha);
        }else{
            playerEntity.setDateUpdate(fecha);
        }
        return playerRepository.save(playerEntity);
    }

    /**
     * inserta un usuario en la tabla
     * @param bean PlayerBean
     * @return PlayerResponse
     */
    public PlayerBean insert(PlayerBean bean) throws ApplicationNotFoundException {
        if (!appService.exist(bean.getIdApplication())){
            throw new ApplicationNotFoundException(AppCodeMessage.PLAYER_NOT_INSERT_FOR_APLLICATION);
        }
        PlayerEntity playerEntity = mapEntity.map(bean, PlayerEntity.class);
        PlayerEntity playerResponse = savePlayer(playerEntity);
        return mapEntity.map(playerResponse, PlayerBean.class);
    }

    public PlayerBean update(PlayerBean bean, String id){
        PlayerEntity playerEntity = playerRepository.findById(id).get();
        playerEntity = updatePlayer(bean, playerEntity);
        playerEntity = savePlayer(playerEntity);
        return mapEntity.map(playerEntity, PlayerBean.class);
    }

    public PlayerBean getById(final String id) throws PlayerNotFoundException {
        return playerRepository.findById(id)
                .map(player -> mapEntity.map(player, PlayerBean.class))
                .orElseThrow(() -> new PlayerNotFoundException(PlayerCodeMessage.ID_NOT_FOUND,id));
    }

    public List<PlayerBean> findWithFilter(Map<String, String> filter) throws PlayerNotFoundException {

        PlayerEntity entity = new PlayerEntity();
        entity.setIdApplication(filter.get(PlayerEntity.PARAM_APPLICATION));
        entity.setUsername(filter.get(PlayerEntity.PARAM_USERNAME));
        entity.setEmail(filter.get(PlayerEntity.PARAM_EMAIL));
        entity.setFacebookId(filter.get(PlayerEntity.PARAM_FACEBOOK));
        entity.setLanguage(filter.get(PlayerEntity.PARAM_LANGUAGE));
        entity.setCountry(filter.get(PlayerEntity.PARAM_COUNTRY));

        List<PlayerBean> playerBeanList = playerRepository.findAll(Example.of(entity,ExampleMatcher.matchingAll())).stream()
                .map(player -> mapEntity.map(player, PlayerBean.class))
                .collect(Collectors.toList());

        if (playerBeanList.isEmpty()){
            throw new PlayerNotFoundException(PlayerCodeMessage.PLAYER_NOT_FOUND);
        }

        return playerBeanList;
    }

    public void delete(String id){
        playerRepository.deleteById(id);
    }

    private PlayerEntity updatePlayer(PlayerBean bean, PlayerEntity player){
        if (StringUtils.isNotBlank(bean.getFacebookId())){
            player.setFacebookId(bean.getFacebookId());
        }
        if (StringUtils.isNotBlank(bean.getLanguage())){
            player.setLanguage(bean.getLanguage());
        }
        if (StringUtils.isNotBlank(bean.getCountry())){
            player.setCountry(bean.getCountry());
        }
        if (StringUtils.isNotBlank(bean.getEmail())){
            player.setEmail(bean.getEmail());
        }
        return player;
    }

    public boolean exist(String id){
        return (playerRepository.countById(id) > 0);
    }

}
