package com.giocondalabs.services.identity;

import com.giocondalabs.entities.identity.HistoryEntity;
import com.giocondalabs.repositories.identity.HistoryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class HistoryServiceImpl implements HistoryService {

    @Inject
    HistoryRepository repository;

    @Override
    public HistoryEntity findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public HistoryEntity findByKeycode(String keycode) {
        return repository.findByKeycode(keycode);
    }

    @Transactional
    @Override
    public void save(HistoryEntity history) {
        if (history.getId() != null) {
            HistoryEntity temp = findById(history.getId());

            temp.setKeycode(history.getKeycode());
            temp.setStartDay(history.getStartDay());
            temp.setStartHour(history.getStartHour());
            temp.setEndDay(history.getEndDay());
            temp.setEndHour(history.getEndHour());
            temp.setVisitorDevice(history.getVisitorDevice());

            repository.persist(temp);
        } else {
            repository.persistAndFlush(history);
        }
    }
}
