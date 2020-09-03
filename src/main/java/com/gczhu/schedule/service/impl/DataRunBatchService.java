package com.gczhu.schedule.service.impl;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.service.TaskExecuteService;
import org.springframework.stereotype.Service;

@Service
public class DataRunBatchService implements TaskExecuteService {
    private static String TASK_NAME = "数据跑批业务";
    @Override
    public void doService(TaskConfig taskConfig) {
        System.out.println("数据跑批业务");
    }

    @Override
    public String getTaskName() {
        return TASK_NAME;
    }
}
