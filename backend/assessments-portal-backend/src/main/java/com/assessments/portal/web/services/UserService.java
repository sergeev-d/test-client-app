package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.user.RegistrationException;
import com.assessments.portal.web.domain.user.User;


public interface UserService  {
    User findByEmail(String email);
    User findById(Long id);
    void register() throws RegistrationException;
}
