package com.assessments.portal.common.results;

import com.assessments.portal.web.domain.user.User;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class LoginResult {
    public static ResponseEntity<ApiResult> build(User user, String realTimeToken){
        Map<String, Object> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("token", realTimeToken);
        userData.put("id", user.getId());
        userData.put("type", user.getUserType());

        ApiResult apiResult = ApiResult.blank().add("user", userData);

        return ResponseEntity.ok(apiResult);
    }
}
