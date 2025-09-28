package com.tutorial.client_service.Service;

import com.tutorial.client_service.Entity.UsersEntity;
import com.tutorial.client_service.Repository.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    IRepositoryUser repositoryUser;

    public String getUser(String user, String pass) {

        UsersEntity userEntity = repositoryUser.findByUsername(user);
        if (userEntity != null) {
            if (Objects.equals(userEntity.username, user) && Objects.equals(userEntity.password, pass))
                return "Usuario existe";
            else
                return "Usuario incorrecto";
        } else
            return null;
    }

    public UsersEntity createUser(UsersEntity user) {

        user.active = true  ;
        return repositoryUser.save(user);
    }
}
