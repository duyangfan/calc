package com.dudu.ms;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class WatchLocker {
    int status=0;
    long start;
    long end;
    long res;

    private Map<String,String> mapInfo=new Hashtable<>();


    public Map<String, String> getMapInfo() {
        return mapInfo;
    }

    public void setMapInfo(String key,String value) {
        this.mapInfo.put(key,value);
    }

    public WatchLocker(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
        this.res=end-this.start;
    }

    public long getTmes() {
        return this.res;
    }
}
