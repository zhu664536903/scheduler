package com.gczhu.schedule.task;

import com.gczhu.schedule.pojo.TaskConfig;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 *
 */
@Component
public class CmdTaskAdapter implements TaskAdapter {
    
    @Override
    public boolean runTask(TaskConfig taskConfig) {
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
