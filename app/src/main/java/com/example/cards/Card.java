package com.example.cards;

public abstract class Card {
    protected String name;
    protected int resImage;
    protected String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String displayValue() {
        return String.valueOf(getValue());
    }

    public abstract Integer getValue();

    public abstract void setValue(int value);

    public int getResImage() {
        return resImage;
    }

    public void setResImage(int resImage) {
        this.resImage = resImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

