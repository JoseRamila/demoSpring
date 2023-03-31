package com.desarrollo.demoSpring.repositories;

import com.desarrollo.demoSpring.entities.Product;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
