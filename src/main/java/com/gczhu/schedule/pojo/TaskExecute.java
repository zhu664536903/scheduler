package com.gczhu.schedule.pojo;

import java.util.Date;

public class TaskExecute {
    private Integer id;
    private Integer taskId;
    private Date planStartTime;//计划启动时间
    private Date endStartTime;//实际启动时间
    private Long executeTime;//执行时长
    private String status;//成功或失败
    private String executeInfo;
}
