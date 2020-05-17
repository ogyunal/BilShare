package com.ogyunal.ogulcan.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogyunal.ogulcan.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
