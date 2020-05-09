package com.bilshare.bilshare.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilshare.bilshare.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
