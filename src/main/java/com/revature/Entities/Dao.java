package com.revature.Entities;

import java.util.List;

/**
 * Dao
 */
public interface Dao<E> {
    void insert(E e);

    List<E> getAll();

    void update(E e);

    void delete(E e);
}