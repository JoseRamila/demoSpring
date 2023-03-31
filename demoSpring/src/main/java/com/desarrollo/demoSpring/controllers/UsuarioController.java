package com.desarrollo.demoSpring.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.desarrollo.demoSpring.services.UsuarioService;


/**
 * Usuario controller.
 */
@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String name,
                        @RequestParam("pass") String pass) {
        boolean isLogin = usuarioService.login(name,pass);
        if(isLogin) {return "index";}
        return"login";
    }
}
