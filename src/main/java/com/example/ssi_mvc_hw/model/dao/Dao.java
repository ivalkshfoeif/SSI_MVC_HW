package com.example.ssi_mvc_hw.model.dao;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(int id);
    Collection<T> getAll();
    int save(T t);
    void update(T t);
    void delete(Integer id);
    boolean exist(Integer id);

}
