package com.airbnb.user_service.repositories;

import com.airbnb.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
