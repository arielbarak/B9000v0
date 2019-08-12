package com.example.b9000v0.Schema.Actions;

public final class SubscriptionAction extends Action{
    private final ActionType type = ActionType.Subscription;
    private final String description = "has subscribed to your channel";

    public ActionType getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return " " + description;
    }
}
