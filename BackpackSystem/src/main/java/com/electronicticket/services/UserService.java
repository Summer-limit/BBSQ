package com.electronicticket.services;

import com.electronicticket.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年02月22日 2022/2/22
 */
public interface UserService {
    User findUserByUserName(String userName);
}
