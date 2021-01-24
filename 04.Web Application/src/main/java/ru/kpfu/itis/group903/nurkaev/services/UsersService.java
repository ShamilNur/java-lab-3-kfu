package ru.kpfu.itis.group903.nurkaev.services;

import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.forms.UserForm;
import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.models.UserSecond;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<User> getAllUsers();
    List<User> getUsersByAge(int age);
    void save(User entity);
    void delete(User entity);
    void update(User entity);
    Optional<User> findById(Long id);
    void signUp(UserForm userForm) throws DuplicateEntryException;
    Optional<UserSecond> findOneByEmail(String email);
    Optional<UserSecond> getUserSecondByUuid(String uuid);
}
