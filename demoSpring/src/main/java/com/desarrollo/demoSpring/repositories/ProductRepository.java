package com.desarrollo.demoSpring.repositories;

import com.desarrollo.demoSpring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
