package com.example.demo;

public class Greeting {
    private String test = "Prosto Test";
    private final long id;
    private final String content;
    private final int number = 5;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    
    public String getTest() {
        return test;
    }

    public String getContent() {
        return content;
    }
    
    public int getChislo() {
        return 6;
    }
}
