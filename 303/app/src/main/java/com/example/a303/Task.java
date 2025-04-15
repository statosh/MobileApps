package com.example.a303;

public class Task {
    private int id;
    private String title;
    private String description;
    private String color;

    public Task() {
    }

    public Task(int id, String title, String description, String color) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.color = color;
    }

    public Task(String title, String description, String color) {
        this.title = title;
        this.description = description;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}