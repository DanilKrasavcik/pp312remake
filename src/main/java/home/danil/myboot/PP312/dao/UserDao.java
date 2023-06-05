package home.danil.myboot.PP312.dao;

import home.danil.myboot.PP312.models.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void delete(long id);
}
