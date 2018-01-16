package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.model.Item;
import org.elsys.ip.rest.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemRepository {



    private static List<Item> itemsList = new ArrayList<Item>();

    public ItemRepository() {
        if (itemsList.size() == 0) {
            itemsList.addAll(getDefaultItems());
        }
    }

    public List<Item> getAllItems() {
        return itemsList;
    }


    public void addMultiItems(List<Item> items) {
        itemsList.addAll(items);
    }

    public List<Item> getDefaultItems() {
        List<Item> defaultItems = new ArrayList<>();

        Item item1 = new Item(1, "topka", 12, "mn qka topka", "RED", 10, "adidas", new Date(), 4, "test", 10, "Sofia");
        Item item2 = new Item(2, "mishka", 24, "lazerna", "WHITE", 30, "razer", new Date(), 5, "test", 10, "Burgas");
        Item item3 = new Item(3, "bambuk", 44, "zverski qk", "GREEN", 5, "neshto", new Date(), 5, "test", 10, "Sofia");

        defaultItems.add(item1);
        defaultItems.add(item2);
        defaultItems.add(item3);

        return defaultItems;
    }


    public void delete(Integer id) {
        List<Item> toRemove = new ArrayList<>();
        for (Item item : itemsList) {
            if (item.getId() == id) {
                toRemove.add(item);
            }
        }

        itemsList.removeAll(toRemove);
    }

    public void insert(Item item) {
        itemsList.add(item);
    }

    public void update(Integer id, Item item) {
        delete(id);
        insert(item);
    }

    public Integer getLastId() {
        Integer result = 0;

        if (itemsList.size() != 0) {
            for (Item item : itemsList) {
                if (item.getId() > result) {
                    result = item.getId();
                }
            }
        }

        return result;
    }
}

