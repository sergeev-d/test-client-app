package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.user.RegistrationException;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl() {}

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseGet(User::new);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseGet(User::new);
    }

    @Override
    public User findById(Long id) {
        // orElseThrow
        return userRepository.findById(id).orElseGet(User::new);
    }

    @Override
    public void register() throws RegistrationException {

    }
}
