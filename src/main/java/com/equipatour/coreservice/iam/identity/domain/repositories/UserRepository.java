package com.equipatour.coreservice.iam.identity.domain.repositories;

import com.equipatour.coreservice.iam.identity.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
