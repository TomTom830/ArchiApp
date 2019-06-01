package com.polytech.todoList.Repository;

import com.polytech.todoList.object.Tasks;

import java.util.List;

public interface TaskRepository {

    List<Tasks> ListeTasks (String username);

    void ajouttask(Tasks tasks);

    void modifiertask(Integer id, String content);

    void supprimetask(Integer id);
}
