package com.desarrollo.demoSpring.controllers;

import com.desarrollo.demoSpring.entities.Login;
import com.desarrollo.demoSpring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/loginrest")
    public ResponseEntity<String>login(@RequestBody Login login){
        if(usuarioService.login(login.getUsername(), login.getPassword())){
            return new ResponseEntity<>("User created", HttpStatus.OK);
        }
        return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
    }
}
