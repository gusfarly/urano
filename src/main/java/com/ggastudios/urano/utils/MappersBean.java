package com.ggastudios.urano.utils;

import com.ggastudios.urano.DTO.BaseRequest;
import com.ggastudios.urano.DTO.BaseResponse;
import com.ggastudios.urano.bean.BaseBean;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class MappersBean<I extends BaseRequest,B extends BaseBean,O extends BaseResponse>{

    private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public B map (I request, Class<B> bean){
        return dozerBeanMapper.map(request,bean);
    }

    public O map (B bean,Class<O> response){
        return dozerBeanMapper.map(bean,response);
    }

}
