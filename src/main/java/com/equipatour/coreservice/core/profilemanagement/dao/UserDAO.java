package com.equipatour.coreservice.core.profilemanagement.dao;

import com.equipatour.coreservice.core.profilemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

}
