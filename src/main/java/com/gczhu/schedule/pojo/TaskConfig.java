package com.gczhu.schedule.pojo;

public class TaskConfig {
    private Integer id;
    private String cronExpression;
    private String taskName;
    private String taskEnName;
    private String taskDescribe;
    private String cmd;
    private String type;//cmd or fixed
    private Integer enable;
    private Integer timeOut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskEnName() {
        return taskEnName;
    }

    public void setTaskEnName(String taskEnName) {
        this.taskEnName = taskEnName;
    }

    public String getTaskDescribe() {
        return taskDescribe;
    }

    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public String toString() {
        return "TaskConfig{" +
                "id=" + id +
                ", cronExpression='" + cronExpression + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskEnName='" + taskEnName + '\'' +
                ", taskDescribe='" + taskDescribe + '\'' +
                ", cmd='" + cmd + '\'' +
                ", type='" + type + '\'' +
                ", enable=" + enable +
                ", timeOut=" + timeOut +
                '}';
    }
}
