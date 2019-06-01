package com.polytech.todoList.business;

import com.polytech.todoList.Repository.TaskRepository;
import com.polytech.todoList.object.Tasks;
import com.polytech.todoList.object.Users;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl( TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addtask(Tasks tasks) {
        taskRepository.ajouttask(tasks);
    }

    @Override
    public void modifytask(Integer id, String content) {
        taskRepository.modifiertask(id,content);
    }

    @Override
    public void deltask(Integer id) {
        taskRepository.supprimetask(id);
    }

    @Override
    public List<Tasks> getListTask(String username) {
        List<Tasks> res = taskRepository.ListeTasks(username);
        return res;
    }
}
