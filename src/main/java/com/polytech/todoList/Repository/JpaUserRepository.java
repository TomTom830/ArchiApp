package com.polytech.todoList.Repository;

import com.polytech.todoList.object.Authority;
import com.polytech.todoList.object.Users;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class JpaUserRepository implements UserRepository  {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public boolean isUsernameDefined(String usrn) {
        boolean res;

        Query query = entityManager.createQuery("SELECT COUNT(s) FROM Users s WHERE username='"+usrn+"'");
        Long nb_username = (Long) query.getSingleResult();
        if(nb_username == 0) res = false;
        else res = true;
        return res;
    }



    @Override
    public void send_registration(Users user, Authority auth) {
        entityManager.persist(user);
        entityManager.persist(auth);
    }

    @Override
    public void modify_Password() {
        Query query = entityManager.createQuery("UPDATE Users SET password = 'tamer' WHERE username='Dom'");
        query.executeUpdate();
    }


}
