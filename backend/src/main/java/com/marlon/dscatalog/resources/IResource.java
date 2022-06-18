package com.marlon.dscatalog.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marlon.dscatalog.services.AbstractService;
import com.marlon.dscatalog.utils.Convertible;

public interface IResource<T extends Convertible<DTO, ID>, DTO extends Convertible<T, ID>, ID> {

	AbstractService<T, DTO, ID> getService();
	Page<DTO> findAllPaged(String filter, Pageable pageable);
}
