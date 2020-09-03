package com.gczhu.schedule.controller;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.task.TaskAdapter;
import com.gczhu.schedule.service.TaskSchduleService;
import com.gczhu.schedule.task.Task;
import com.gczhu.schedule.utils.TaskAdapterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    TaskSchduleService taskSchduleService;

    @Autowired
    TaskAdapterUtil taskAdapterUtil;

    public TaskController() {
    }

    @RequestMapping("/add")
    public String add(){
        TaskConfig taskConfig = new TaskConfig();
        taskConfig.setId(1);
        taskConfig.setCmd("java");
        taskConfig.setEnable(1);
        taskConfig.setCronExpression("00 28 11 * * *");
        System.out.println( taskAdapterUtil.getTaskAdapter(taskConfig.getType()));
        Task task = new Task(taskConfig,taskAdapterUtil.getTaskAdapter(taskConfig.getType()));
        taskSchduleService.addTask(task);

        return "ok";
    }
    @RequestMapping("/edit")
    public String edit(){
        TaskConfig taskConfig = new TaskConfig();
        taskConfig.setId(1);
        taskConfig.setTaskEnName("timeOutOrderService");
        taskConfig.setType("1");
        taskConfig.setEnable(1);
        taskConfig.setCronExpression("*/5 * * * * *");
        Task task = new Task(taskConfig, taskAdapterUtil.getTaskAdapter(taskConfig.getType()));
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
        Task task = new Task(taskConfig, null);
        taskSchduleService.deleteTask(task);
        return "ok";
    }


}
