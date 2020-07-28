package com.xr.util;

public class Myth implements Runnable{

    private int numm;

    public Myth(int numm) {
        this.numm = numm;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(numm*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mmmmmmmm:"+numm);
    }

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            (new Myth(i)).run();
        }
    }
}
