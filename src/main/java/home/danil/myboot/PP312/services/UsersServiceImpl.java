package home.danil.myboot.PP312.services;



import home.danil.myboot.PP312.dao.UserDAO;
import home.danil.myboot.PP312.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService {

    private final UserDAO userDAO;

    @Autowired
    public UsersServiceImpl(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {

        return userDAO.findAll();
    }

    @Override
    public User findOne(long id) {
        return userDAO.findOne(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void update(long id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDAO.delete(id);
    }


}
