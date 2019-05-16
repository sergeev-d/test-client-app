package com.assessments.portal.web.controllers;

import com.assessments.portal.common.results.ApiResult;
import com.assessments.portal.common.results.GetUserResult;
import com.assessments.portal.common.results.LoginResult;
import com.assessments.portal.common.security.TokenManager;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class UserApiController {
    private UserService userService;
    private TokenManager tokenManager;

    public UserApiController(UserService userService, TokenManager tokenManager) {
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @GetMapping("/user")
    public ResponseEntity<ApiResult> getUser(@RequestHeader Map<String, String> headers){
        String authHeader = headers.get("authorization");

        if (authHeader != null && !authHeader.isEmpty()){
            Long userId = tokenManager.verifyJwt(authHeader.split("\\s")[1]);
            User user = userService.findById(userId);
            return GetUserResult.build(user);
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("user not found", "401"));
        }
    }
}
