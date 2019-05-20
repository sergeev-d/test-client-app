package com.assessments.portal.web.controllers;

import com.assessments.portal.common.results.ApiResult;
import com.assessments.portal.common.security.TokenManager;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class ProfileController {
    private UserService userService;
    private TokenManager tokenManager;

    public ProfileController(UserService userService, TokenManager tokenManager) {
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @GetMapping("/profiles")
    public ResponseEntity<ApiResult> getProfile(@RequestHeader Map<String, String> headers){
        String authHeader = headers.get("authorization");

        if (authHeader != null && !authHeader.isEmpty()){
            Long userId = tokenManager.verifyJwt(authHeader.split("\\s")[1]);
            User user = userService.findById(userId);
            return ResponseEntity.ok(ApiResult.blank().add("profile", user));
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("user not found", "401"));
        }
    }

    @PatchMapping("/profiles")
    public ResponseEntity<ApiResult> registrateProfile(@RequestHeader Map<String, String> headers,
                                                       @RequestBody User profile){
        String authHeader = headers.get("authorization");
        if (authHeader != null && !authHeader.isEmpty()){
            Long userId = tokenManager.verifyJwt(authHeader.split("\\s")[1]);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("user not found", "401"));
        }
    }

}
