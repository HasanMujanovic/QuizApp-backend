package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.Kviz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "kvizovi")
public interface KvizRepo extends JpaRepository<Kviz, Integer> {
}
