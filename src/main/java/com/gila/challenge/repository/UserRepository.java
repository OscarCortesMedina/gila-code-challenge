package com.gila.challenge.repository;

import com.gila.challenge.entity.User;
import com.gila.challenge.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE :category MEMBER OF u.categories")
    List<User> findBySubscribedCategories(Category category);
}
