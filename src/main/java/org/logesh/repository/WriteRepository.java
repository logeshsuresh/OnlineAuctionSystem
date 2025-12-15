package org.logesh.repository;

public interface WriteRepository<T, U> {
    T save(T entity);
    void delete(U id);
}
