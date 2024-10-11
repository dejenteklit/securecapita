package com.dejen.securecapita.service.implementation;

import com.dejen.securecapita.domain.User;
import com.dejen.securecapita.dto.UserDTO;
import com.dejen.securecapita.dtomapper.UserDTOMapper;
import com.dejen.securecapita.repository.UserRepository;
import com.dejen.securecapita.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;
    private final UserDTOMapper userDTOMapper;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
