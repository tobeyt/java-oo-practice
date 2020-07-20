package com.twu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HotSearch {
    private List<HotItem> hotSearchList;

    public HotSearch() {
        hotSearchList = new ArrayList();
    }

    public void addHotSearch(HotItem item) {
        hotSearchList.add(item);
    }


    public void getHotSearchRank() {
        List<HotItem> newItems = hotSearchList.stream().filter(cur -> cur.getPrice() == 0).sorted((a, b) -> b.getVotes() - a.getVotes()).collect(Collectors.toList());

        for (int i = 0; i < hotSearchList.size(); i++) {
            if (hotSearchList.get(i).getPrice() > 0) {
                newItems.add(i, hotSearchList.get(i));
            }
        }

        for (int i = 0; i < newItems.size(); i++) {
            System.out.print(i + 1 + " ");
            System.out.println(newItems.get(i));
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

    public void successPaidHotSearch(String name, double paid, int rank) throws CloneNotSupportedException {
        for (int i = 0; i < hotSearchList.size(); i++) {
            if (hotSearchList.get(i).getName().equals(name)) {
                hotSearchList.get(i).setPrice(paid);
                HotItem item = (HotItem) hotSearchList.get(i).clone();
                hotSearchList.remove(i);
                hotSearchList.remove(rank - 1);
                hotSearchList.add(rank - 1, item);
                break;
            }
        }
    }

    public double getHotSearchPrice(String hotSearchName) {
        return hotSearchList.stream().filter(cur -> cur.getName().equals(hotSearchName)).collect(Collectors.toList()).get(0).getPrice();

    }
}
