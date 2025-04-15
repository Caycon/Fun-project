package com.caycon.model;

import java.util.List;

public class Question {
    private int id;
    private String content;
    private String category;
    private double point;
    private List<Answer> answers;

    public Question(int id, String content, String category, double point, List<Answer> answers) {
        this.id = id;
        this.content = content;
        this.category = category;
        this.point = point;
        this.answers = answers;
    }

    public Question(String content, String category, double point, List<Answer> answers) {
        this.content = content;
        this.category = category;
        this.point = point;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", point=" + point +
                '}';
    }
}