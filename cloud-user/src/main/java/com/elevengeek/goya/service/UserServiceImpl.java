package com.elevengeek.goya.service;

import com.elevengeek.goya.entiy.UserEntity;
import com.elevengeek.goya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author cj
 * @create 2020-02-04-16:44
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    /**
     * @description 通过用户Id获取用户
     * @param [id]
     * @return com.elevengeek.goya.entiy.UserEntity
     */
    public UserEntity getUser(String id){
        if(!userRepository.existsById(id)){
            return null;
        }
        return userRepository.findById(id).get();
    }

    /**
     * @description 保存用户
     * @param [userEntity]
     * @return com.elevengeek.goya.entiy.UserEntity
     */
    public UserEntity saveUser(UserEntity userEntity){
        if(StringUtils.isEmpty(userEntity)){
            return null;
        }
        userEntity.setCreateBy("sys");
        userEntity.setUpdateBy("sys");
        return userRepository.save(userEntity);
    }
}
