package com.twu;

public class HotItem implements Cloneable {
    private String name;
    private int votes;
    private boolean isSuperHotSearch;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HotItem(String name) {
        this.name = name;
        this.votes = 0;
        this.isSuperHotSearch = false;
        this.price = 0;
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        HotItem item = (HotItem) super.clone();
        return item;
    }
}
