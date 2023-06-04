package home.danil.myboot.PP312.services;





import home.danil.myboot.PP312.models.User;

import java.util.List;


public interface UsersService {

    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void delete(long id);
}
