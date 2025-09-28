package com.tutorial.client_service.Repository;

import com.tutorial.client_service.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioClient extends JpaRepository<ClientEntity, Long> {


}
