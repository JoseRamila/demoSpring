package com.desarrollo.demoSpring.controllers;

import com.desarrollo.demoSpring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/login")
    public String showLogin(Model model) {
        return "login";
	}

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){
        if(usuarioService.login(username, password)){
            return  "redirect:/";
        }
        else {
            model.addAttribute("error","login failed");
            return "login";
        }
    }

    @RequestMapping("/changepassword")
    public String showChangePass(Model model) { return  "changepassword";}

    @RequestMapping(value= "/changepassword", method = RequestMethod.POST)
    public String changepassword(@RequestParam("username") String username,
                                 @RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 Model model){
        if(usuarioService.changePassword(username, oldPassword, newPassword)){
            return "redirect:/login";
        }
        else{
            model.addAttribute("error", "Password change failed")
            return "changepassword";
        }
    }





}
