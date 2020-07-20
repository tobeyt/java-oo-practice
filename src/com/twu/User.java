package com.twu;

public class User {
    private String userName;
    private int votes;

    public User(String userName) {
        this.userName = userName;
        this.votes = 10;
    }

    public String getUserName() {
        return userName;
    }

    public int getVotes() {
        return votes;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public boolean voteToHotSearch(int votesCount) {
        if (votesCount > this.votes) {
            return false;
        }
        this.votes -= votesCount;
        return true;
    }
}
