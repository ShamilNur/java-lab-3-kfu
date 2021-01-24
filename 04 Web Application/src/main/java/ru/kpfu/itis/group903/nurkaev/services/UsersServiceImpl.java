package ru.kpfu.itis.group903.nurkaev.services;

import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.forms.UserForm;
import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.models.UserSecond;
import ru.kpfu.itis.group903.nurkaev.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<User> getUsersByAge(int age) {
        return usersRepository.findAllByAge(age);
    }

    @Override
    public void save(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        usersRepository.delete(entity);
    }

    @Override
    public void update(User entity) {
        usersRepository.update(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<UserSecond> findOneByEmail(String email) {
        return usersRepository.findOneByEmail(email);
    }

    @Override
    public Optional<UserSecond> getUserSecondByUuid(String uuid) {
        return usersRepository.getUserSecondByUuid(uuid);
    }

    @Override
    public void signUp(UserForm userForm) throws DuplicateEntryException {
        Optional<UserSecond> userOptional = usersRepository.findOneByEmail(userForm.getEmail());
        if (userOptional.isPresent()) {
            throw new DuplicateEntryException();
        }

        usersRepository.signUp(userForm);
    }
}
