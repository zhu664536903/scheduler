## 定时任务功能
  本项目主要实现页面配置定时任务功能，包含命令式和非命令式两种类型任务,整体组成如下：
###  一、任务Task
    通过接口编程，可快速增加非命令式任务。
    1.任务配置TaskConfig,负责保存任务的基本配置。
    2.任务适配器接口TaskAdapter，根据任务的类型来选择对应的适配器，在适配器中使用对应TaskExecuteService来执行任务
    3.任务执行接口TaskExecuteService，根据任务配置执行具体的业务
    
###  二、调度
    主要使用了spring中的ThreadPoolTaskScheduler任务调度类，其scheduler方法支持使用cron定时方式触发。
    1.任务调度接口TaskSchduleService对spring任务调度框架进行封装，负责保存、调度、停上等任务管理工作。
### 名词解释
    命令式任务：指shell命令，使用在需要调用脚本的场景
    非命令式任务:程序中写死固定的任务，使用在任务固定，执行时间有改动场景。
