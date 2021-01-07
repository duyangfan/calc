package com.dudu.ms;

public class WatchLocker {
    int status=0;
    long start;
    long end;
    long res;
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
