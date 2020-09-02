package com.gczhu.schedule.service.impl;

import com.gczhu.schedule.pojo.TaskConfig;
import com.gczhu.schedule.service.TaskExecuteService;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CmdTaskExecuteService implements TaskExecuteService {
    
    @Override
    public boolean doService(TaskConfig taskConfig) {
        Process exec = null;
        int exitValue = 1;
        InputStream inputStream = null;
        try {
            exec = Runtime.getRuntime().exec(taskConfig.getCmd());
            inputStream = exec.getInputStream();
            exitValue = exec.waitFor();
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            if(exitValue != 0){
                inputStream = exec.getErrorStream();
            }

            BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(new BufferedInputStream(inputStream)));

            while ((line = bufferedReader.readLine()) !=null){
                stringBuilder.append("\n");
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder.toString());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("任务"+taskConfig.getTaskName()+"执行报错!");

        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return exitValue==0;

    }
}
