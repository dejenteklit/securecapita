package com.dejen.securecapita.repository;

import com.dejen.securecapita.domain.User;

import java.util.Collection;

public interface UserRepository <T extends User>{
    /*Basic CRUD Operations*/
    T create(T data);
    Collection<T> List(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);
    /*More complex Operations*/

}
