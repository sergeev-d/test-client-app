package com.assessments.portal.web.controllers;

import com.assessments.portal.common.results.ApiResult;
import com.assessments.portal.common.results.LoginResult;
import com.assessments.portal.common.security.TokenManager;
import com.assessments.portal.web.domain.user.Login;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/login")
    public @ResponseBody() ResponseEntity<ApiResult> login(@RequestBody Login login){
        User user = userService.findByEmail(login.getEmail());
        if (user.getPassword().equals(login.getPassword())){
            String token = tokenManager.jwt(user.getId());
            return LoginResult.build(user, token);
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("incorrect password", "401"));
        }

    }
}
