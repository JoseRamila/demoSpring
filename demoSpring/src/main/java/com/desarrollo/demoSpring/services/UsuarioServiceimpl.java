package com.desarrollo.demoSpring.services;


import com.desarrollo.demoSpring.entities.Usuario;
import com.desarrollo.demoSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceimpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    public boolean login(String user, String pass){
        boolean result = false;
        List <Usuario> listusuario = usuarioRepository.findAll();
        Usuario usuario = listusuario.get(0);
        System.out.println(usuario.toString());
        if(usuario != null){
            if(usuario.getPassword().equals(pass))
                result = true;
        }
        return result;
    }
    @Override
    public boolean changePassword(String user, String oldPass, String newPass) {
        boolean result=false;
        List<Usuario> listUsuario = usuarioRepository.findByNombre(user);
        if(listUsuario.isEmpty()) return result;
        Usuario usuario = listUsuario.get(0);
        if(login(user, oldPass)){
            usuario.setPassword(newPass);
            usuarioRepository.save(usuario);
            result = true;
        }
        return result;
    }


}