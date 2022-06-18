package com.marlon.dscatalog.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marlon.dscatalog.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT DISTINCT obj FROM Category obj "
			+ "WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',?1,'%')) ")
	Optional<Page<Category>> findAllPaged(String filter, Pageable pageable);
}
