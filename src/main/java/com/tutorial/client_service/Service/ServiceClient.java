package com.tutorial.client_service.Service;

import com.tutorial.client_service.Entity.ClientEntity;
import com.tutorial.client_service.Repository.IRepositorioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class ServiceClient {

    @Autowired
    IRepositorioClient repositoryClient;

    public ClientEntity getClient(long id) {

        return repositoryClient.findById(id).orElse(null);
    }
}
