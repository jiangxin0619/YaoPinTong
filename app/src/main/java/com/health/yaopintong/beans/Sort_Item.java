package com.health.yaopintong.beans;

import java.util.ArrayList;

/**
 * Created by aaa on 15-4-30.
 */
public class Sort_Item {
    private String name;
    private ArrayList<String> content;
    private int afterBackground;
    private int laterBackground;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

    public int getAfterBackground() {
        return afterBackground;
    }

    public void setAfterBackground(int afterBackground) {
        this.afterBackground = afterBackground;
    }

    public int getLaterBackground() {
        return laterBackground;
    }

    public void setLaterBackground(int laterBackground) {
        this.laterBackground = laterBackground;
    }

    @Override
    public String toString() {
        return "Sort_Item{" +
                "name='" + name + '\'' +
                ", content=" + content +
                ", afterBackground=" + afterBackground +
                ", laterBackground=" + laterBackground +
                '}';
    }
}
