package com.example.service;

import com.example.common.Result;
import com.example.entity.Task;
import com.example.mapper.TaskMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Resource
    private TaskMapper taskMapper;
    public List<Task> selectAll() {
        return taskMapper.selectAll();
    }

    public void addTask(Task task) {
        taskMapper.insertTask(task);
    }

    public void updateTask(Task task) {
        taskMapper.updateTask(task);
    }

    public int deleteById(Long id) {
        return taskMapper.deleteById(id);
    }
}
