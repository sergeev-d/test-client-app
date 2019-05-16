package com.assessments.portal.web.domain.user;

import com.assessments.portal.web.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_type", nullable = false)
    private Integer userType;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "middle_name", length = 45)
    private String middleName;

    @Column(name = "organization_name", length = 100)
    private String organizationName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;


    public static User create(Long id, Integer userType, String username, String password, String phoneNumber, String email,
                              String firstName, String lastName, String middleName, String organizationName, Date createdDate, Date updatedDate) {
        User user = new User();
        user.id = id;
        user.userType = userType;
        user.username = username;
        user.password = password;
        user.phoneNumber = phoneNumber;
        user.email = email;
        user.firstName = firstName;
        user.lastName = lastName;
        user.middleName = middleName;
        user.organizationName = organizationName;
        user.createdDate = createdDate;
        user.updatedDate = updatedDate;

        return user;
    }

    public Long getId() {
        return id;
    }

    public Integer getUserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userType=" + userType +
                ", username=" + username +
                ", password=" + password +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
