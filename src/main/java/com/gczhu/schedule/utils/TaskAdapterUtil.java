package com.gczhu.schedule.utils;

import com.gczhu.schedule.task.TaskAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TaskAdapterUtil {

    @Autowired
    private Map<String, TaskAdapter> map;

    public TaskAdapter getTaskAdapter(String type) {

        if ("1".equals(type)) {
            return map.get("fixTaskAdapter");
        } else {
            return map.get("cmdTaskAdapter");
        }

    }
}
