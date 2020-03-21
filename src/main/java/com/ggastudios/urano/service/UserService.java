package com.ggastudios.urano.service;

import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.entities.UserEntity;
import com.ggastudios.urano.exception.UserExistsException;
import com.ggastudios.urano.exception.UserNotFoundException;
import com.ggastudios.urano.repository.UserRepository;
import com.ggastudios.urano.utils.MappersEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MappersEntity<UserBean, UserEntity> map;

    private UserEntity saveUser(UserEntity userEntity){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSSXXX");
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
    public UserBean insert(UserBean bean) throws UserExistsException {
        if (userRepository.countByIdApplicationAndUsername(bean.getIdApplication(),bean.getUsername()) > 0){
            throw new UserExistsException("username existe para ese idApplication");
        }
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

    public UserBean getById(final String id) throws UserNotFoundException {
        return userRepository.findById(id)
                .map(user -> map.entityToBean(user,UserBean.class))
                .orElseThrow(() -> new UserNotFoundException("usuario " + id + " no encontrado"));
    }

    public UserBean getByIdApplicationAndUsername(String idApplication, String username) throws UserNotFoundException {
        return userRepository.findByIdApplicationAndUsername(idApplication,username)
                .map( user -> map.entityToBean(user,UserBean.class))
                .orElseThrow(() -> new UserNotFoundException("usuario no encontrado o no existe para la aplicación"));
    }

    public List<UserBean> getByIdApplication(String idApplication) throws UserNotFoundException {
        List<UserBean> userBeanList = userRepository.findByIdApplication(idApplication).stream()
                .map( user -> map.entityToBean(user,UserBean.class)).collect(Collectors.toList());
        if (userBeanList.isEmpty()){
            throw new UserNotFoundException("No se encuentran usuarios para esta aplicacion");
        }
        return userBeanList;
    }

    public List<UserBean> getAll() throws UserNotFoundException {
        List<UserBean> userBeanList = userRepository.findAll().stream()
                .map(user -> map.entityToBean(user,UserBean.class))
                .collect(Collectors.toList());
        if (userBeanList.isEmpty()){
            throw new UserNotFoundException("No se encuentran usuarios con esas condiciones");
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

}
