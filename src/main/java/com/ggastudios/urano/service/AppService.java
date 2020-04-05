package com.ggastudios.urano.service;

import com.ggastudios.urano.bean.AppBean;
import com.ggastudios.urano.entities.AppEntity;
import com.ggastudios.urano.exception.ApplicationNotFoundException;
import com.ggastudios.urano.repository.AppRepository;
import com.ggastudios.urano.utils.MappersEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private MappersEntity<AppBean, AppEntity> mapperEntity;

    private AppEntity save(AppEntity entity){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSSXXX");
        String fecha = simpleDateFormat.format(Calendar.getInstance().getTime());
        if (entity.getStartDate() == null){
            entity.setStartDate(fecha);
        }else{
            entity.setUpdateDate(fecha);
        }
        return appRepository.save(entity);
    }

    public AppBean insert(AppBean bean) throws ApplicationNotFoundException {
        AppEntity entity = mapperEntity.map(bean,AppEntity.class);
        entity = save(entity);
        return mapperEntity.map(entity,AppBean.class);
    }

    public AppBean findById(String idApplication) throws ApplicationNotFoundException {
        return appRepository.findById(idApplication)
                .map(entity -> mapperEntity.map(entity,AppBean.class))
                .orElseThrow(() -> new ApplicationNotFoundException("no existe la aplicacion"));
    }

    public AppBean updateApp(AppBean bean,String idApplication) throws ApplicationNotFoundException {
        AppEntity entity = appRepository.findById(idApplication)
                .orElseThrow(() -> new ApplicationNotFoundException("no existe la aplicacion"));
        update(entity,bean);
        save(entity);
        return mapperEntity.map(entity,AppBean.class);
    }

    private void update(AppEntity entity, AppBean bean){
        if (StringUtils.isNotBlank(bean.getName())){
            entity.setName(bean.getName());
        }
        if (StringUtils.isNotBlank(bean.getDescription())){
            entity.setDescription(bean.getDescription());
        }
        if (StringUtils.isNotBlank(bean.getVersion())){
            entity.setVersion(bean.getVersion());
        }
        if (StringUtils.isNotBlank(bean.getOwner())){
            entity.setOwner(bean.getOwner());
        }
    }
}