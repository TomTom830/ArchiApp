package com.polytech.todoList.business;

import com.polytech.todoList.object.Tasks;

import java.util.List;

public interface TaskService {

    void addtask(Tasks tasks);

    void modifytask(Integer id, String content);

    void deltask(Integer id);

    List<Tasks> getListTask(String username);
}
