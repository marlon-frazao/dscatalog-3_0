package com.marlon.dscatalog.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.marlon.dscatalog.utils.Convertible;

@Service
public interface IService<T extends Convertible<DTO, ID>, DTO extends Convertible<T, ID>, ID> {

	JpaRepository<T, ID> getRepository();
	Page<DTO> findAllPaged(String filter, Pageable pageable);
}
