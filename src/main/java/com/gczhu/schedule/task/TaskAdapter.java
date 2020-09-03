package com.gczhu.schedule.task;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.task.Task;

/**
 * 抽象命令式与非命令式任务
 */
public interface TaskAdapter {
    public boolean runTask(TaskConfig taskConfig);
}
