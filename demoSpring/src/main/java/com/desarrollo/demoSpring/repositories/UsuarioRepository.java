package com.desarrollo.demoSpring.repositories;

import com.desarrollo.demoSpring.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNombre(String name);
}
