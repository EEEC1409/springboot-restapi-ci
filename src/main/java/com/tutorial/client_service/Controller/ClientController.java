package com.tutorial.client_service.Controller;

import com.tutorial.client_service.Entity.ClientEntity;
import com.tutorial.client_service.Service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client-service2")
public class ClientController {

    @Autowired
    ServiceClient serviceClient;
    @GetMapping(value = "consulta/{id}")
    public ResponseEntity<ClientEntity> getCliente(@PathVariable long id) {
        ClientEntity entity = serviceClient.getClient(id);
        if(entity == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(entity);
        //here a change

    }

}


