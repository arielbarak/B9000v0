package com.example.b9000v0.Schema.Actions;

public final class CommentAction extends Action {
    private final ActionType type = ActionType.Comment;
    private final String description = "commented on your post";

    public ActionType getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return " " + description;
    }
}
