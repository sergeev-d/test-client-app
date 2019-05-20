package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.user.RegistrationException;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private Map<Long, User> users;

    public UserServiceImpl() {
        this.users = new HashMap<>();

        User expertUser = User.create(1L, 1, "ivanov-i", "11111111", "79000000000", "expert@mail.ru",
                "Иван", "Иванов", null, "ИП Корпоративные оценки", Date.from(Instant.now()), null);

        User clientUser = User.create(2L, 2, "alex-n", "22222222", "79000000001", "client@mail.ru",
                "Александр", "Николаевич", null, "Рога и копыта", Date.from(Instant.now()), null);

        this.users.put(1L, expertUser);
        this.users.put(2L, clientUser);
    }

    @Override
    public User findByEmail(String email) {
        User result = null;
        for (Map.Entry<Long, User> user : users.entrySet()){
            if (user.getValue().getEmail().equals(email)) {
                result = user.getValue();
            }
        }
        return result == null?new User():result;
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public void register() throws RegistrationException {

    }
}
