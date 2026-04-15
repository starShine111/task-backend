package com.example.mapper;

import com.example.common.Result;
import com.example.entity.Task;

import java.util.List;

public interface TaskMapper {
    List<Task> selectAll();
    int insertTask(Task task);
    int updateTask(Task task);
    int deleteById(Long id);

}
