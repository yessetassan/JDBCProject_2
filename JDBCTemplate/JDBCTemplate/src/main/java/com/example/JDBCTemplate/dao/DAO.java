package com.example.JDBCTemplate.dao;

import java.util.List;
import java.util.Optional;

public interface DAO <T> {

    List<T> list();

    void create(T t);

    Optional<T> get(int id);

    void delete(int id);

}
