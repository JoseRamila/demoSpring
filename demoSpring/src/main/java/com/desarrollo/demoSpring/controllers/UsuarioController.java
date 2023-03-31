package com.desarrollo.demoSpring.controllers;



import com.desarrollo.demoSpring.entities.Product;
import com.desarrollo.demoSpring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("login/")
    public String showLogin(Model model) {
        return "login";
	}

}
