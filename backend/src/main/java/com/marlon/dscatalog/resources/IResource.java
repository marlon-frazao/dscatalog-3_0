package com.marlon.dscatalog.resources;

import com.marlon.dscatalog.services.IService;
import com.marlon.dscatalog.utils.Convertible;

public interface IResource<T extends Convertible<DTO, ID>, DTO extends Convertible<T, ID>, ID> {

	IService<T, DTO, ID> getService();
}
