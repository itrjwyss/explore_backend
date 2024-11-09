package com.giocondalabs.repositories.identity;

import com.giocondalabs.entities.identity.VisitorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VisitorRepository implements PanacheRepository<VisitorEntity> {

    public VisitorEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public VisitorEntity findByEmailAndPassword(String email, String password) {
        return find(
            "email = :email and password = :password",
            email,
            password
        ).firstResult();
    }
}
