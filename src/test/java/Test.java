import ch.qos.logback.core.util.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gczhu.schedule.vo.DownSelectVo;
import org.apache.commons.io.FileUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main1(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setThreadFactory(new ThreadFactory() {
            AtomicInteger a = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("taskSchdule-thread"+a.incrementAndGet());
                return thread;
            }
        });
        threadPoolTaskScheduler.setPoolSize(2);
        threadPoolTaskScheduler.initialize();



    }
    @org.junit.Test
    public void  testCmd() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("java ");

        BufferedReader bufferedReaderError = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(p.getErrorStream())));
        BufferedReader bufferedReaderInfo = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(p.getInputStream())));

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReaderError.readLine()) !=null){
            stringBuilder.append("\n");
            stringBuilder.append(line);
        }
        while ((line = bufferedReaderInfo.readLine()) !=null){
            stringBuilder.append("\n");
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder.toString());
        System.out.println(p.waitFor());
    }
    @org.junit.Test
    public void testResource() throws IOException {
        URL url = Test.class.getResource("/json/fixTaskConfig.json");
        System.out.println(url.getPath());

        String s = FileUtils.readFileToString(new File(url.getPath()), "utf-8");
        System.out.println(s);
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(objectMapper.readValue(s, DownSelectVo[].class));

    }

}
