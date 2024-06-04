package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.KvizOdgovori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "kviz-odgovori")
public interface KvizOdgovoriRepo extends JpaRepository<KvizOdgovori,Long> {
}
