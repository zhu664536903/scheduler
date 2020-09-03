package com.gczhu.schedule.service.impl;

import com.gczhu.schedule.service.TaskSchduleService;
import com.gczhu.schedule.task.Task;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Service
public class SpringTaskSchduleService implements TaskSchduleService {
    //map
    Map<String, ScheduledFuture<?>> map = new ConcurrentHashMap<String, ScheduledFuture<?>>();
    ThreadPoolTaskScheduler scheduler = null;
    SpringTaskSchduleService(){
        this.scheduler = new ThreadPoolTaskScheduler();
        this.scheduler.setPoolSize(2);
        this.scheduler.initialize();
    }



    @Override
    public void addTask(Task task) {
        System.out.println("保存任务："+task.getTaskConfig().toString());
        //创建任务
        if (task.getTaskConfig().getEnable() == 1){
            startTask(task);
        }
    }

    @Override
    public void editTask(Task task) {
        System.out.println("更改任务："+task.getTaskConfig().toString());
        String key = String.valueOf(task.getTaskConfig().getId());
        stopTask(key);

        //根据条件判断是否重启
        if (task.getTaskConfig().getEnable() == 1){
            startTask(task);
        }

    }

    @Override
    public void deleteTask(Task task) {
        //删除操作
        stopTask(String.valueOf(task.getTaskConfig().getId()));
    }

    @Override
    public void stopTask(String id) {
        //停止
        ScheduledFuture<?> scheduledFuture = map.get(id);
        if (scheduledFuture !=null){
            scheduledFuture.cancel(false);
            map.remove(id);
        }
    }

    @Override
    public void startTask(Task task) {
        //创建任务
        ScheduledFuture<?> future = scheduler.schedule(task, new CronTrigger(task.getTaskConfig().getCronExpression()));
        map.putIfAbsent(String.valueOf(task.getTaskConfig().getId()),future);
    }
    @PostConstruct
    public void initTask(){
        System.out.println("从数据库读取任务");
    }
}
