package com.ggastudios.urano.utils;

import com.ggastudios.urano.bean.BaseBean;
import com.ggastudios.urano.entities.BaseEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class MappersEntity<B extends BaseBean,E extends BaseEntity> {

    private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public E beanToEntity(B bean, Class<E> entity){
       return dozerBeanMapper.map(bean,entity);
    }

    public B entityToBean(E entity,Class<B> bean){
        return dozerBeanMapper.map(entity,bean);
    }

}
