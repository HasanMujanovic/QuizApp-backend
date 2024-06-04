package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.KvizPitanja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KvizPitanjaRepo extends JpaRepository<KvizPitanja,Long> {
}
