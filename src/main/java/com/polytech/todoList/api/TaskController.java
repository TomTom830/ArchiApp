package com.polytech.todoList.api;

import com.polytech.todoList.business.TaskService;
import com.polytech.todoList.object.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/addTask")
    public void addtask(@RequestBody Tasks tasks, Principal principal) {
        tasks.setId_user(principal.getName());
        taskService.addtask(tasks);
    }

    @GetMapping("/getTasks")
    public List<Tasks> getTasks(Principal principal) {
        List<Tasks> res = taskService.getListTask(principal.getName());
        return res;
    }

    @DeleteMapping("/delTask")
    public void delTask(@RequestParam("id") Integer id, Principal principal) {
        taskService.deltask(id);
    }

    @PutMapping("/modifTask")
    public void modifTask(@RequestParam("id") Integer id, @RequestParam("content") String content) {
        taskService.modifytask(id,content);
    }
}