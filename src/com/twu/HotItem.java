package com.twu;

public class HotItem {
    private String name;
    private int votes;

    public HotItem(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes += votes;
    }

    @Override
    public String toString() {
        return this.name + " " + this.votes;
    }
}
