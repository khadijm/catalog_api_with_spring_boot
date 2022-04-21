package com.catalog.com.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.com.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
