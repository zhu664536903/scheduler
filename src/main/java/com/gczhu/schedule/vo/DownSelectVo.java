package com.gczhu.schedule.vo;

import java.io.Serializable;

public class DownSelectVo implements Serializable {
    private String label;
    private String value;

    public String getLabel() {
        return label;
    }

    public DownSelectVo() {
    }

    public DownSelectVo(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
