package com.assessments.portal.web.controllers;

import com.assessments.portal.common.results.GetUserResult;
import com.assessments.portal.common.security.TokenManager;
import com.assessments.portal.web.domain.user.SimpleUser;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserApiController {
    private UserService userService;
    private TokenManager tokenManager;

    public UserApiController(UserService userService, TokenManager tokenManager) {
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @GetMapping("/api/user")
    public ResponseEntity getUser(SimpleUser currentUser){
        User user = userService.findById(currentUser.getUserId());
        String realTimeToken = tokenManager.jwt(user.getId());

        return GetUserResult.build(user, realTimeToken);
    }
}
