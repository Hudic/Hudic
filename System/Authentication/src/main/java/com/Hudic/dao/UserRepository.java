package com.Hudic.dao;

import com.Hudic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * jiangcq
 * 2018/12/7 14:28
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
