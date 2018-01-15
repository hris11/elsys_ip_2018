package org.elsys.ip.rest.repository;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.elsys.ip.rest.model.Color;
import org.elsys.ip.rest.model.Item;
import org.elsys.ip.rest.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.*;


public class UserRepository {

    private static List<User> userList = new ArrayList<User>();
    /*        Arrays.asList(
                    new User(1, "Milko", "123", new ArrayList<Item>()),
                    new User(2, "Hristian", "123", new ArrayList<Item>())
            )
    );*/

    public UserRepository() {
        if (userList.size() == 0) {
            List<Item> defaultItems = new ArrayList<>();
            List<String> defaultTags = new ArrayList<>();
            defaultTags.add("item");

            Item item1 = new Item(1, "topka", 12, "mn qka topka", "RED", 10, "adidas", new Date(), 4, "test", 10, "Sofia");
            Item item2 = new Item(2, "mishka", 24, "lazerna", "WHITE", 30, "razer", new Date(), 5, "test", 10, "Burgas");
            Item item3 = new Item(3, "bambuk", 44, "zverski qk", "GREEN", 5, "neshto", new Date(), 5, "test", 10, "Sofia");

            defaultItems.add(item1);
            defaultItems.add(item2);
            defaultItems.add(item3);

            userList.add(new User(1, "Milko", "123", defaultItems));
            userList.add(new User(1, "Hristian", "123", defaultItems));
        }
    }

    public List<User> getUsers() {
        return userList;
    }

    public User getUserById(int id) {
        for (User u : userList) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();

        for (User u : userList) {
            items.addAll(u.getUserItems());
        }

        return items;
    }

    public void delete() {

    }

    public void insert() {

    }

    public void update() {

    }

}
