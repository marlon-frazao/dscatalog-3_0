package com.marlon.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marlon.dscatalog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
