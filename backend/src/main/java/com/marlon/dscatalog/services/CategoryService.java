package com.marlon.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marlon.dscatalog.dto.CategoryDTO;
import com.marlon.dscatalog.entities.Category;
import com.marlon.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService extends AbstractService<Category, CategoryDTO, Long> {

	@Autowired
	private CategoryRepository repository;
	
	@Override
	public JpaRepository<Category, Long> getRepository() {
		return repository;
	}
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		return repository.findAll().stream().map(Category::convert).collect(Collectors.toList());
	}

	@Override
	public Page<CategoryDTO> findAllPaged(Object filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CategoryDTO updateData(Category entity, CategoryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
