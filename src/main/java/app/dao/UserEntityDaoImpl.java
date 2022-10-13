package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserEntityDaoImpl implements UserDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c", User.class);
        return query.getResultStream().toList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, (long) id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
