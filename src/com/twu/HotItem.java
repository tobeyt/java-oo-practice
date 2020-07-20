package com.twu;

public class HotItem {
    private String name;
    private int votes;
    private boolean isSuperHotSearch;

    public HotItem(String name) {
        this.name = name;
        this.votes = 0;
        this.isSuperHotSearch = false;
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

    public boolean isSuperHotSearch() {
        return isSuperHotSearch;
    }

    public void setSuperHotSearch(boolean superHotSearch) {
        isSuperHotSearch = superHotSearch;
    }

    @Override
    public String toString() {
        return this.name + " " + this.votes;
    }
}
