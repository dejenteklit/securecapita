package com.dejen.securecapita.service;

import com.dejen.securecapita.domain.User;
import com.dejen.securecapita.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
}
