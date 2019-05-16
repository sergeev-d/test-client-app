package com.assessments.portal.web.domain.user;

import java.io.Serializable;
import java.util.Objects;

public class SimpleUser implements Serializable {
    private static final long serialVersionUID = -7144174657188362966L;

    private Long userId;
    private String username;
    private String password;
    private Integer type;

    public SimpleUser(User user) {
        this.userId = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.type = user.getUserType();
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUser that = (SimpleUser) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
