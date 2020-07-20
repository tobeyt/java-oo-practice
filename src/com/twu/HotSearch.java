package com.twu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotSearch {
    private List<HotItem> hotSearchList;
    private int len = 0;

    public HotSearch() {
        hotSearchList = new ArrayList();
    }

    public void addHotSearch(HotItem item) {
        len++;
        hotSearchList.add(item);
    }

    public int getCountOfHotSearch() {
        return len;
    }

    public void getHotSearchRank() {
        Collections.sort(hotSearchList, (a, b) -> b.getVotes() - a.getVotes());
        for (int i = 1; i <= this.len; i++) {
            System.out.print(i + " ");
            System.out.println(hotSearchList.get(i - 1));
        }
    }

    public void votedToHotSearch(String name, int votedCount) {
        hotSearchList.forEach(cur -> {
            if (cur.getName().equals(name)) {
                if (cur.isSuperHotSearch()) {
                    cur.setVotes(votedCount * 2);
                } else {
                    cur.setVotes(votedCount);
                }
            }
        });
    }
}
