package home.danil.myboot.PP312.dao;

import home.danil.myboot.PP312.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User findOne(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User updatedUser) {

        User oldUser = findOne(id);
        oldUser.setName(updatedUser.getName());
        oldUser.setAge(updatedUser.getAge());
        oldUser.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findOne(id));
    }
}
