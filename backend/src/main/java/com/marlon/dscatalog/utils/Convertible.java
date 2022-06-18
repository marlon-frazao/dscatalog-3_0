package com.marlon.dscatalog.utils;

public interface Convertible<T, ID> {

	T convert();
	ID getId();
}
