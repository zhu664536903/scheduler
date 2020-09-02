package com.gczhu.schedule.task;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.service.TaskExecuteService;

public class Task implements Runnable{
    private TaskExecuteService taskExecuteService;
    private TaskConfig taskConfig;
    public Task(TaskConfig taskConfig, TaskExecuteService taskExecuteService) {
        this.taskExecuteService = taskExecuteService;
        this.taskConfig = taskConfig;
    }

    @Override
    public void run() {
        taskExecuteService.doService(taskConfig);
    }

    public TaskConfig getTaskConfig() {
        return taskConfig;
    }
}
