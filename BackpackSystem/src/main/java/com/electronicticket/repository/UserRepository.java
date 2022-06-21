package com.electronicticket.repository;

import com.electronicticket.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年02月22日 2022/2/22
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);
}
