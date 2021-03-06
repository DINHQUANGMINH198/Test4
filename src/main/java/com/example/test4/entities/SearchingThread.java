package com.example.test4.entities;
import java.util.ArrayList;
import java.util.List;

public class SearchingThread extends Thread{
    private List<List<Integer>> listSearchInput;

    private Array arraySorted;

    private DisplayThread displayThread;

    public SearchingThread() {
        listSearchInput = new ArrayList<>();
    }

    public void addDisplayThread(DisplayThread displayThread){
        this.displayThread = displayThread;
    }

    public synchronized void addSearchInput(List<Integer> searchInput){
        listSearchInput.add(searchInput);
        this.notify();
    }

    public synchronized void addSearch(Array arraySorted){
        this.arraySorted = arraySorted;
        this.notify();
    }

    private  void startSearch(List<Integer> searchInput){
        displayThread.clear();
        for(int i = 0 ; i < arraySorted.getLength(); i++){
            if(searchInput.contains(arraySorted.get(i))){
                displayThread.addResult(new Result(i,arraySorted.get(i)));
                synchronized (this){
                    try {
                        this.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        synchronized (this) {
            this.notify();
        }
    }

    @Override
    public void run() {
        while(true){
            if(!listSearchInput.isEmpty() && arraySorted != null){
                System.out.println("Start Searching");
                List<Integer> listInput = listSearchInput.remove(0);
                startSearch(listInput);
            }else {
                try {
                    synchronized (this){
                        wait();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
