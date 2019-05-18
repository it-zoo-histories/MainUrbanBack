package com.stopysinger.core.api.repository;

import com.stopysinger.core.api.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    public Optional<List<History>> findAllByUserId(long userId);

    public Optional<History> findByUserId(long userId);
}
