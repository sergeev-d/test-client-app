package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.user.RegistrationException;
import com.assessments.portal.web.domain.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findById(Long id);

    void register() throws RegistrationException;
}
