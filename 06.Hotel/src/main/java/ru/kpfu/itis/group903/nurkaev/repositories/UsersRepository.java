package ru.kpfu.itis.group903.nurkaev.repositories;

import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.group903.nurkaev.dto.LoginDto;
import ru.kpfu.itis.group903.nurkaev.dto.UserDto;
import ru.kpfu.itis.group903.nurkaev.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findOneByEmail(String email);
    void deleteByEmail(String email);
    void updateByEmail(String firstName, String lastName, String email);

    void signUp(UserDto userDto) throws DuplicateEntryException;
    void signIn(LoginDto loginDto) throws WrongEmailOrPasswordException;
}
