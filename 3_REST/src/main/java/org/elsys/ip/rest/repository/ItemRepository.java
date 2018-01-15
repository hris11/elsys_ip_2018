package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.model.Item;

import java.util.List;

public class ItemRepository {

    private UserRepository userRepository = new UserRepository();

    public List<Item> getAllItems() {
        return userRepository.getAllItems();
    }
}

