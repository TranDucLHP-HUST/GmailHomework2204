package com.example.gmail;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemModel {
    String capId;
    String text1Id;
    String text2Id;
    String timeId;
    boolean isSelected;
    int color;

    public ItemModel() { }

    public ItemModel(String capId, String text1Id, String text2Id, String timeId) {
        this.capId = capId;
        this.text1Id = text1Id;
        this.text2Id = text2Id;
        this.timeId = timeId;
        this.isSelected = false;
        Random random=new Random();
        color=random.nextInt();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public String getCapId() {
        return capId;
    }

    public void setCapId(String capId) {
        this.capId = capId;
    }

    public String getText1Id() {
        return text1Id;
    }

    public void setText1Id(String text1Id) {
        this.text1Id = text1Id;
    }

    public String getText2Id() {
        return text2Id;
    }

    public void setText2Id(String text2Id) {
        this.text2Id = text2Id;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
