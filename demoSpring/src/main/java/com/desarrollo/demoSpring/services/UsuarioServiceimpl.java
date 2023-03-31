package com.desarrollo.demoSpring.services;



import com.desarrollo.demoSpring.entities.Product;
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
        List <Usuario> listusuario = usuarioRepository.findByNombre(user);
        Usuario usuario = listusuario.get(0);
        System.out.println(usuario.toString());
        if(usuario != null){
            if(usuario.getPassword().equals(pass))
                result = true;
        }
        return result;
    }


}