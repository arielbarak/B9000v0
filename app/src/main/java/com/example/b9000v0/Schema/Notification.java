package com.example.b9000v0.Schema;

import com.example.b9000v0.Schema.Actions.Action;

import java.util.Date;

public class Notification {
    private String notification_id;
    private Action action;
    private String triggering_user_id;
    private String effected_user_id;
    private Date action_time;

    public String getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getTriggering_user_id() {
        return triggering_user_id;
    }

    public void setTriggering_user_id(String triggering_user_id) {
        this.triggering_user_id = triggering_user_id;
    }

    public String getEffected_user_id() {
        return effected_user_id;
    }

    public void setEffected_user_id(String effected_user_id) {
        this.effected_user_id = effected_user_id;
    }

    public Date getAction_time() {
        return action_time;
    }

    public void setAction_time(Date action_time) {
        this.action_time = action_time;
    }
}

