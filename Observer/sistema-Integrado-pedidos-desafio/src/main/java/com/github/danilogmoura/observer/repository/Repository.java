package com.github.danilogmoura.observer.repository;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();
}
