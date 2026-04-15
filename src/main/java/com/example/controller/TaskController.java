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
    @GetMapping("/test")
    public String test() {
        return "ok";
    }
    @PostMapping("/addTask")
    public Result addTask(@RequestBody Task task){
        if (task.getTaskName() == null || task.getTaskName().trim().isEmpty()) {
            return Result.error("任务名称不能为空");
        }
        task.setCreateTime(new Date());
        if (task.getStatus() == null || task.getStatus().isEmpty()) {
            task.setStatus("进行中");
        }
        taskService.addTask(task);
        return Result.success(task);
    }
    @PutMapping("/updateTask/{id}")
    public Result updateTask(@PathVariable Long id,@RequestBody Task task){
        task.setId(id);
        taskService.updateTask(task);
        return Result.success(task);
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
