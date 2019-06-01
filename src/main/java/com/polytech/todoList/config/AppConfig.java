package com.polytech.todoList.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.todoList.Repository.*;
import com.polytech.todoList.business.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {



    @Bean
    UserRepository userRepository(){ return new JpaUserRepository(); }

    @Bean
    TaskRepository taskRepository(){return  new JpaTaskRepository(); }

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        //dataSource.setURL("jdbc:mysql://localhost:3306/todoList");
        dataSource.setURL("jdbc:mysql://mysql-tomtom830.alwaysdata.net:3306/tomtom830_todolist");
        dataSource.setUser("tomtom830");
        dataSource.setPassword("appliwebarchi13");
        dataSource.setDatabaseName("tomtom830_todolist");
        return dataSource;
    }


    @Bean
    RegisterService registerService(){return new RegisterServiceImpl(userRepository());}

    @Bean
    TaskService taskService(){return new TaskServiceImpl( taskRepository()); }

}
