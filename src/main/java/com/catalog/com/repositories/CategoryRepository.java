package com.catalog.com.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.com.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
