package com.bmc.mclib.tasks;

import com.bmc.mclib.script.McScript;

import java.util.Random;

public abstract class Task {
    public boolean enabled = true;
    public int delay = 0;
    public String executionMessage = "Generic Task";
    public static Task state;
    public McScript s;
    public Random r = new Random();

    protected Task(McScript script){
        this.s = script;
        refreshObjects();
    }

    protected Task(McScript script, String executionMessage){
        this.s = script;
        this.executionMessage = executionMessage;
        refreshObjects();
    }

    public final int doExecute(){
        prologue();
        execute();
        return delay;
    }

    private final void prologue(){
        state = this;
        refreshObjects();
    }

    public void refreshObjects(){}

    public abstract void execute();
    public abstract boolean validate();

    public String toString(){
        return executionMessage;
    }
}
