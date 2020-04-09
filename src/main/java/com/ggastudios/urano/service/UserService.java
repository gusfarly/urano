package com.ggastudios.urano.service;

import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.entities.UserEntity;
import com.ggastudios.urano.exception.*;
import com.ggastudios.urano.exception.code.AppCodeMessage;
import com.ggastudios.urano.exception.code.UserCodeMessage;
import com.ggastudios.urano.repository.UserRepository;
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
public class UserService extends BaseService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppService appService;

    @Autowired
    private MappersEntity<UserBean, UserEntity> mapEntity;

    private UserEntity saveUser(UserEntity userEntity){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constanst.DATE_FORMAT_PATTERN);
        String fecha = simpleDateFormat.format(Calendar.getInstance().getTime());
        if (userEntity.getId() == null){
            userEntity.setDateStart(fecha);
        }else{
            userEntity.setDateUpdate(fecha);
        }
        return userRepository.save(userEntity);
    }

    /**
     * inserta un usuario en la tabla
     * @param bean UserBean
     * @return UserResponse
     */
    public UserBean insert(UserBean bean) throws ApplicationNotFoundException {
        if (!appService.exist(bean.getIdApplication())){
            throw new ApplicationNotFoundException(AppCodeMessage.USER_NOT_INSERT_FOR_APLLICATION);
        }
        UserEntity userEntity = mapEntity.map(bean,UserEntity.class);
        UserEntity userResponse = saveUser(userEntity);
        return mapEntity.map(userResponse,UserBean.class);
    }

    public UserBean update(UserBean bean,String id){
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity = updateUser(bean,userEntity);
        userEntity = saveUser(userEntity);
        return mapEntity.map(userEntity,UserBean.class);
    }

    public UserBean getById(final String id) throws UserNotFoundException {
        return userRepository.findById(id)
                .map(user -> mapEntity.map(user,UserBean.class))
                .orElseThrow(() -> new UserNotFoundException(UserCodeMessage.ID_NOT_FOUND,id));
    }

    public List<UserBean> findWithFilter(Map<String, String> filter) throws UserNotFoundException {

        UserEntity entity = new UserEntity();
        entity.setIdApplication(filter.get(UserEntity.PARAM_APPLICATION));
        entity.setUsername(filter.get(UserEntity.PARAM_USERNAME));
        entity.setEmail(filter.get(UserEntity.PARAM_EMAIL));
        entity.setFacebookId(filter.get(UserEntity.PARAM_FACEBOOK));
        entity.setLanguage(filter.get(UserEntity.PARAM_LANGUAGE));
        entity.setCountry(filter.get(UserEntity.PARAM_COUNTRY));

        List<UserBean> userBeanList = userRepository.findAll(Example.of(entity,ExampleMatcher.matchingAll())).stream()
                .map(user -> mapEntity.map(user,UserBean.class))
                .collect(Collectors.toList());

        if (userBeanList.isEmpty()){
            throw new UserNotFoundException(UserCodeMessage.USER_NOT_FOUND);
        }

        return userBeanList;
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    private UserEntity updateUser(UserBean bean, UserEntity user){
        if (StringUtils.isNotBlank(bean.getFacebookId())){
            user.setFacebookId(bean.getFacebookId());
        }
        if (StringUtils.isNotBlank(bean.getLanguage())){
            user.setLanguage(bean.getLanguage());
        }
        if (StringUtils.isNotBlank(bean.getCountry())){
            user.setCountry(bean.getCountry());
        }
        if (StringUtils.isNotBlank(bean.getEmail())){
            user.setEmail(bean.getEmail());
        }
        return user;
    }

    public boolean exist(String id){
        return (userRepository.countById(id) > 0);
    }

}
