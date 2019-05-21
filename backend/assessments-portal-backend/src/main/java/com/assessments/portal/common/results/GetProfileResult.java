package com.assessments.portal.common.results;

import com.assessments.portal.web.domain.user.User;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class GetProfileResult {
    public static ResponseEntity<ApiResult> build(User user){
        Map<String, Object> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("id", user.getId());
        userData.put("type", user.getUserType());
        ApiResult apiResult = ApiResult.blank().add("profile", userData);
        return ResponseEntity.ok(apiResult);
    }
}
