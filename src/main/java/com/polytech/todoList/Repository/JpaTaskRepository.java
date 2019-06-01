package com.polytech.todoList.Repository;

import com.polytech.todoList.object.Tasks;
import com.polytech.todoList.object.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaTaskRepository implements TaskRepository {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Tasks> ListeTasks(String username) {
        Query query = entityManager.createQuery("SELECT s FROM Tasks s WHERE id_user= '"+username+"'");
        return query.getResultList();
    }

    @Override
    public void ajouttask(Tasks tasks) {
        entityManager.persist(tasks);
    }

    @Override
    public void modifiertask(Integer id, String content) {
        Query query = entityManager.createQuery("UPDATE Tasks SET content = :content WHERE id="+id);
        query.setParameter("content", content);
        query.executeUpdate();
    }

    @Override
    public void supprimetask(Integer id) {
        Tasks t = entityManager.find( Tasks.class, id);
        entityManager.remove(t);
    }
}
