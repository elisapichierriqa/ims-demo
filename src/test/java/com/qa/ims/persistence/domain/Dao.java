package com.qa.ims.persistence.domain;

import java.util.List;

public interface Dao<T> {
	
    List<T> readAll();
    
    T create(T t);
     
    T update(T t);

	void delete(Long id);

}
