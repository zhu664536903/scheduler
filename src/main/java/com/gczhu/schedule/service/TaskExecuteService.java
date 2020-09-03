package com.gczhu.schedule.service;

import com.gczhu.schedule.pojo.TaskConfig;

/**
 * 该接口负责非命令式任务具体业务，如处理超时订单，数据跑批等。
 */
public interface TaskExecuteService {
    public void doService(TaskConfig taskConfig);
}
