package com.example.b9000v0.Schema.Actions;

public abstract class Action {

    public enum ActionType {
        Like, Comment, Subscription
    }

    public abstract String getDescription();
}


