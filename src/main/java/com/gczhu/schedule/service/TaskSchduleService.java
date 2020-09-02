package com.gczhu.schedule.service;

import com.gczhu.schedule.task.Task;

public interface TaskSchduleService {

    public void addTask(Task task);//保存任务配置并调度
    public void editTask(Task task);//编辑任务并调度或停止
    public void deleteTask(Task task);//删除任务并停止调度
    public void stopTask(String id);//停止调度
    public void startTask(Task task);//立即执行任务

}
