package ru.kpfu.itis.group903.nurkaev.repositories;

import ru.kpfu.itis.group903.nurkaev.forms.UserForm;
import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.models.UserSecond;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    List<User> findAllByAge(Integer age);

    void signUp(UserForm userForm);

    void save(UserSecond entity);

    Optional<UserSecond> findOneByEmail(String email);

    Optional<UserSecond> getUserSecondByUuid(String uuid);
}
