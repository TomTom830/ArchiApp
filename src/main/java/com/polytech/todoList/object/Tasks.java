package com.polytech.todoList.object;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Tasks {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "id_user")
    private String id_user;

    public Tasks(){}
    public Tasks(String content) {
        this.content = content;
    }


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", id_user='" + id_user + '\'' +
                '}';
    }
}
