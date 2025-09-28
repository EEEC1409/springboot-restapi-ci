package com.tutorial.client_service.Controller;

import com.tutorial.client_service.Entity.UsersEntity;
import com.tutorial.client_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user-service")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("consulta")
    public ResponseEntity<String> getCliente(@RequestParam(name = "user") String user,
                                             @RequestParam(name = "pass") String pass) {
        String entity = userService.getUser(user, pass);
        if(entity == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<String>(entity, HttpStatus.OK);

    }

    @PostMapping("create")
    public ResponseEntity<UsersEntity> createCliente(@RequestBody UsersEntity user) {
        UsersEntity entity = userService.createUser(user);
        return new ResponseEntity<UsersEntity>(entity, HttpStatus.OK);

    }
}
