package com.gczhu.schedule.controller;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.service.TaskExecuteService;
import com.gczhu.schedule.service.TaskSchduleService;
import com.gczhu.schedule.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    TaskExecuteService taskExecuteService;

    @Autowired
    TaskSchduleService taskSchduleService;

    @RequestMapping("/add")
    public String add(){
        TaskConfig taskConfig = new TaskConfig();
        taskConfig.setId(1);
        taskConfig.setCmd("java");
        taskConfig.setEnable(1);
        taskConfig.setCronExpression("*/2 * * * * *");
        Task task = new Task(taskConfig, taskExecuteService);
        taskSchduleService.addTask(task);
        return "ok";
    }
    @RequestMapping("/edit")
    public String edit(){
        TaskConfig taskConfig = new TaskConfig();
        taskConfig.setId(1);
        taskConfig.setCmd("java");
        taskConfig.setEnable(1);
        taskConfig.setCronExpression("*/5 * * * * *");
        Task task = new Task(taskConfig, taskExecuteService);
        taskSchduleService.editTask(task);
        return "ok";
    }
    @RequestMapping("/delete")
    public String delete(){
        TaskConfig taskConfig = new TaskConfig();
        taskConfig.setId(1);
        taskConfig.setCmd("java");
        taskConfig.setEnable(1);
        taskConfig.setCronExpression("*/5 * * * * *");
        Task task = new Task(taskConfig, taskExecuteService);
        taskSchduleService.deleteTask(task);
        return "ok";
    }


}
