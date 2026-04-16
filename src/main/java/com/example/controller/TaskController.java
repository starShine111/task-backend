package com.example.controller;

import com.example.common.Result;
import com.example.entity.Task;
import com.example.service.TaskService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping("/selectAll")
    public Result selectAll(){
        List<Task> list=taskService.selectAll();
        return Result.success(list);
    }
    @PostMapping("/addTask")
    public Result addTask(@RequestBody Task task){
        if (task.getTaskName() == null || task.getTaskName().trim().isEmpty()) {
            return Result.error("任务名称不能为空");
        }
        task.setCreateTime(new Date());
        taskService.addTask(task);
        return Result.success();
    }
    @PutMapping("/updateTask")
    public Result updateTask(@RequestBody Task task){
        if (task.getId() == null) {
            return Result.error("任务ID不能为空");
        }
        if (task.getTaskName() == null || task.getTaskName().trim().isEmpty()) {
            return Result.error("任务名称不能为空");
        }
        taskService.updateTask(task);
        return Result.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id){
        int result=taskService.deleteById(id);
        if(result>0){
            return Result.success("删除成功");
        }else {
            return Result.error("删除失败");
        }
    }
}
