package org.elsys.ip.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class User {
    @JsonIgnore
    private Integer id;

    private String username;

    private String password;

    private List<Item> userItems;

    public User() {}

    public User(Integer id, String username, String password, List<Item> userItems) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userItems = userItems;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<Item> userItems) {
        this.userItems = userItems;
    }

    public void addItem(Item item) {
        this.userItems.add(item);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
