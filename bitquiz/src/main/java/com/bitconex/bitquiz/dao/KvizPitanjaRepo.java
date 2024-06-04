package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.KvizPitanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "kviz-pitanja")
public interface KvizPitanjaRepo extends JpaRepository<KvizPitanja,Long> {
}
