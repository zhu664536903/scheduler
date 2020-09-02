package com.gczhu.schedule.service;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.task.Task;

public interface TaskExecuteService {
    public boolean doService(TaskConfig taskConfig);
}
