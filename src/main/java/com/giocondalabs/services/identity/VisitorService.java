package com.giocondalabs.services.identity;

import com.giocondalabs.entities.identity.VisitorEntity;

public interface VisitorService {

    VisitorEntity findById(Long id);

    VisitorEntity findByEmail(String email);

    VisitorEntity findByEmailAndPassword(String email, String password);

    VisitorEntity save(VisitorEntity visitor);
}
