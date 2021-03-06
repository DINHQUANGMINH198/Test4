package com.example.test4.entities;

import java.util.ArrayList;
import java.util.List;

public class ListResult {
    private List<Result> results;

    boolean checkAddListener = false;
    boolean endThread = false;

    public ListResult() {
        results = new ArrayList<>();
    }

    public void clearState() {
        results.clear();
        endThread = false;
    }

    public synchronized  boolean isEndThread() {
        return endThread;
    }

    public synchronized void setEndThread(boolean endThread) {
        this.endThread = endThread;
    }

    public boolean isCheckAddListener() {
        return checkAddListener;
    }

    public void setCheckAddListener(boolean checkAddListener) {
        this.checkAddListener = checkAddListener;
    }

    public void add(Result result){
        results.add(result);
        checkAddListener = true;
    }

    public ListResult(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public Result get(int index){
        return results.get(index);
    }

    public Result getLastItem(){
        return results.get(results.size()-1);
    }
}
