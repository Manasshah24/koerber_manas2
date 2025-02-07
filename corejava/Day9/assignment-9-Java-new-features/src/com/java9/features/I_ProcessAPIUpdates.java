package com.java9.features;

public class I_ProcessAPIUpdates {
    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        ProcessHandle.Info info = currentProcess.info();
        System.out.println("Complete Process Inforamtion:\n"+info);
        System.out.println("Process ID: " + currentProcess.pid());
        System.out.println("Command: " + info.command());
        System.out.println("Start Time: " + info.startInstant());
        System.out.println("Total CPU Time Acquired: "+info.totalCpuDuration().get());


    }
}
