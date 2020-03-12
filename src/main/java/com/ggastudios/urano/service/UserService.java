package com.ggastudios.urano.service;

import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.entities.UserEntity;
import com.ggastudios.urano.exception.UserNotFoundException;
import com.ggastudios.urano.repository.UserRepository;
import com.ggastudios.urano.utils.MappersEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MappersEntity<UserBean, UserEntity> map;

    private UserEntity saveUser(UserEntity userEntity){

        if (userEntity.getId() == null){
            userEntity.setDateStart(Calendar.getInstance());
        }else{
            userEntity.setDateUpdate(Calendar.getInstance());
        }
        return userRepository.save(userEntity);
    }

    /**
     * inserta un usuario en la tabla
     * @param bean UserBean
     * @return UserResponse
     */
    public UserBean insert(UserBean bean){
        UserEntity userEntity = map.beanToEntity(bean,UserEntity.class);
        UserEntity userResponse = saveUser(userEntity);
        return map.entityToBean(userResponse,UserBean.class);
    }

    public UserBean update(UserBean bean,String id){
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity = updateUser(bean,userEntity);
        userEntity = saveUser(userEntity);
        return map.entityToBean(userEntity,UserBean.class);
    }

    public UserBean getById(final String id) throws Exception {
        return userRepository.findById(id)
                .map(user -> map.entityToBean(user,UserBean.class))
                .orElseThrow(() -> new UserNotFoundException("usuario " + id + " no encontrado"));
    }

    public List<UserBean> getAll(){
        return userRepository.findAll().stream()
                .map(user -> map.entityToBean(user,UserBean.class))
                .collect(Collectors.toList());
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    private UserEntity updateUser(UserBean bean, UserEntity user){
        if (StringUtils.isNotBlank(bean.getFacebookId())){
            user.setFacebookId(bean.getFacebookId());
        }
        if (StringUtils.isNotBlank(bean.getIdioma())){
            user.setIdioma(bean.getIdioma());
        }
        if (StringUtils.isNotBlank(bean.getPais())){
            user.setPais(bean.getPais());
        }
        if (StringUtils.isNotBlank(bean.getEmail())){
            user.setEmail(bean.getEmail());
        }
        if (StringUtils.isNotBlank(bean.getName())){
            user.setName(bean.getName());
        }
        return user;
    }

}
