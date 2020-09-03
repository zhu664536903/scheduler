package com.gczhu.schedule.task;

import com.gczhu.schedule.pojo.TaskConfig;

public class Task implements Runnable{
    private TaskAdapter taskAdapter; //执行内容
    private TaskConfig taskConfig;//任务配置
    public Task(TaskConfig taskConfig, TaskAdapter taskAdapter) {
        this.taskAdapter = taskAdapter;
        this.taskConfig = taskConfig;
    }

    @Override
    public void run() {
        taskAdapter.runTask(taskConfig);
    }

    public TaskConfig getTaskConfig() {
        return taskConfig;
    }
}
