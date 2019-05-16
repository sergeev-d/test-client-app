package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.user.RegistrationException;
import com.assessments.portal.web.domain.user.SimpleUser;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return User.create(1l, 1, "test", "12345678", "","123@mail.ru",
                "User", "", null, "Org", Date.from(Instant.now()), null);
//        return userRepository.findByEmail(email).get();
    }

    @Override
    public User findById(Long id) {
        return User.create(1l, 1, "test", "12345678", "","123@mail.ru",
                "User", "", null, "Org", Date.from(Instant.now()), null);
//        return userRepository.findById(id).get();
    }

    @Override
    public void register() throws RegistrationException {

    }
}
