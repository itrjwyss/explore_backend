package com.giocondalabs.services.identity;

import com.giocondalabs.entities.identity.VisitorEntity;
import com.giocondalabs.repositories.identity.VisitorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VisitorServiceImpl implements VisitorService {

    @Inject
    VisitorRepository repository;

    @Override
    public VisitorEntity findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public VisitorEntity findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public VisitorEntity findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    @Transactional
    @Override
    public VisitorEntity save(VisitorEntity visitor) {
        if (visitor.getId() == null) {
            VisitorEntity temp = new VisitorEntity();

            temp.setName(visitor.getName());
            temp.setLastName(visitor.getLastName());
            temp.setEmail(visitor.getEmail());
            temp.setPassword(visitor.getPassword());
            temp.setRegistrationDate(visitor.getRegistrationDate());
            temp.setStatus(visitor.getStatus());
            temp.setCountry(visitor.getCountry());
            temp.setCity(visitor.getCity());
            temp.setCity(visitor.getCity());

            repository.persist(temp);
            return temp;
        } else {
            repository.persistAndFlush(visitor);
            return visitor;
        }
    }
}
