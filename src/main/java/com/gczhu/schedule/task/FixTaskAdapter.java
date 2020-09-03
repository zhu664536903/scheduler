package com.gczhu.schedule.task;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.service.TaskExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 固定任务
 */
@Component
public class FixTaskAdapter implements TaskAdapter {
    @Autowired
    ApplicationContext applicationContext;
    @Override
    public boolean runTask(TaskConfig taskConfig) {
        TaskExecuteService bean = applicationContext.getBean(
                taskConfig.getTaskEnName(),TaskExecuteService.class);
        System.out.println("使用适配器:"+bean);
        if (bean != null) bean.doService(taskConfig);
        return true;
    }
}
