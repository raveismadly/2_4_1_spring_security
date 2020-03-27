package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> allUsers() {
////        List<User> list;
////        Session session = sessionFactory.getCurrentSession();
////        list = session.createQuery("from User ").list();
////        session.close();
////        return list;
//        return sessionFactory.getCurrentSession().createQuery("from User ").list();
//    }
//
//    @Override
//    public void addUser(User user) {
//        Session session = sessionFactory.openSession();
//        session.save(user);
//        session.close();
//    }
//
//    @Override
//    public void deleteUser(User user) {
//        sessionFactory.getCurrentSession().delete(user);
//    }
//
//    @Override
//    public void updateUser(User user) {
//        sessionFactory.getCurrentSession().update(user);
//    }
//
//    @Override
//    public User getUserById(int id) {
//        return (User) sessionFactory.getCurrentSession().createQuery("from User where id=:id")
//                .setParameter("id", id).uniqueResult();
//    }
//
//    @Override
//    public User getUserByName(String name) {
//        return (User) sessionFactory.getCurrentSession().createQuery("from User where name=:name")
//                .setParameter("name", name).uniqueResult();
//    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
//        return entityManager.find(User.class, name);
        User user = null;

        try (Session session = sessionFactory.openSession()) {
            user =(User) session.createQuery(" from User where name=:name")
                    .setParameter("name",name).uniqueResult();
            System.out.println("this method is work on dao & return usr by name "+ user.getName()+" "+user.getRoles());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROORRR IN METHOD GETUSERBYNAME");
        }
        return user;
    }
}
