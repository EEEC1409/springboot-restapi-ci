package com.tutorial.client_service.Repository;

import com.tutorial.client_service.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface IRepositoryUser extends JpaRepository<UsersEntity, Integer> {


   // UsersEntity findByUsername(String username);

    @Query("SELECT u FROM UsersEntity u WHERE u.username = :username order by id desc limit 1")
    UsersEntity findByUsername(@Param("username") String username);
}
