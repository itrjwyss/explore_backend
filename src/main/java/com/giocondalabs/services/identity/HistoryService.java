package com.giocondalabs.services.identity;

import com.giocondalabs.entities.identity.HistoryEntity;

public interface HistoryService {

    HistoryEntity findById(Long id);

    HistoryEntity findByKeycode(String keycode);

    void save(HistoryEntity history);
}
