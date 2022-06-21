package com.electronicticket.services.impl;

import com.electronicticket.domain.User;
import com.electronicticket.repository.UserRepository;
import com.electronicticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年02月22日 2022/2/22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findUserByUserName(userName);
    }

}
