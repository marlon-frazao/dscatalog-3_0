package com.marlon.dscatalog.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marlon.dscatalog.utils.Convertible;

@Service
public abstract class AbstractService<T extends Convertible<DTO, ID>, DTO extends Convertible<T, ID>, ID> 
										implements IService<T, DTO, ID> {

	@Transactional
	public DTO save(DTO dto) {
		return getRepository().save(dto.convert()).convert();
	}
	
	@Transactional
	public DTO update(DTO dto, ID id) {
		T entity = getRepository().getOne(id);
		entity = updateData(entity, dto);
		return getRepository().save(entity).convert();
	}
	
	protected abstract T updateData(T entity, DTO dto);

	@Transactional(readOnly = true)
	public DTO getById(ID id) {
		return getRepository().findById(id).get().convert();
	}
	
	@Transactional
	public void deleteById(ID id) {
		getRepository().deleteById(id);
	}
	
	public void deleteById(List<ID> ids) {
		ids.forEach(x -> deleteById(x));
	}
}
