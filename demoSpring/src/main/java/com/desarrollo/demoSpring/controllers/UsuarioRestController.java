package com.desarrollo.demoSpring.controllers;

import com.desarrollo.demoSpring.entities.ChangePassRequest;
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

    @PostMapping("changepassrest")
    public ResponseEntity<String> changePassword(RequestBody ChangePassRequest changePassRequest){
        if(usuarioService.changePassword(changePassRequest.getUsername(), changePassRequest.getOldPass(), changePassRequest.getNewPass())){
            return new ResponseEntity<String>("Successful change", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Change failed, wrong data", HttpStatus.NOT_FOUND);
        }
    }


}
