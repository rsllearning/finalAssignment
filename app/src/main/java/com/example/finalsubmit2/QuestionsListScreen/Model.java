package com.example.finalsubmit2.QuestionsListScreen;

public class Model {

    int id;
    String title;
    int correctAnswer;
    String MCQ[];

    public Model(int id, String title, int correctAnswer, String[] MCQ) {
        this.id = id;
        this.title = title;
        this.correctAnswer = correctAnswer;
        this.MCQ = MCQ;
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

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getMCQ() {
        return MCQ;
    }

    public void setMCQ(String[] MCQ) {
        this.MCQ = MCQ;
    }
}
