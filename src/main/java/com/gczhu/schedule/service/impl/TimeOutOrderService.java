package com.gczhu.schedule.service.impl;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.service.TaskExecuteService;
import org.springframework.stereotype.Service;

@Service
public class TimeOutOrderService implements TaskExecuteService {
    private static String TASK_NAME = "超时订单处理任务";
    @Override
    public void doService(TaskConfig taskConfig) {
        System.out.println("处理超时订单");
    }

    @Override
    public String getTaskName() {
        return TASK_NAME;
    }
}
