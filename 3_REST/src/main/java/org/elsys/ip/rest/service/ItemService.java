package org.elsys.ip.rest.service;

import org.elsys.ip.rest.model.Item;
import org.elsys.ip.rest.repository.ItemRepository;

import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemService {

    private ItemRepository itemRepository = new ItemRepository();

    public List<Item> filterQueries(List<Item> input, String queryKey, String queryValue) {
        switch (queryKey) {
            case "name": {
                input = input.stream().filter(i -> i.getName().equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "price": {
                input = input.stream().filter(i -> ("" + i.getPrice()).equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "description": {
                input = input.stream().filter(i -> i.getDescription().equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "color": {
                input = input.stream().filter(i -> i.getColor().equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "discount": {
                input = input.stream().filter(i -> ("" + i.getDiscount()).equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "brand": {
                input = input.stream().filter(i -> i.getBrand().equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "publishDate": {
                input = input.stream().filter(i -> i.getPublishDate().toString().equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "score": {
                input = input.stream().filter(i -> ("" + i.getScore()).equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "tags": {
                input = input.stream().filter(i -> i.getTags().equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "availability": {
                input = input.stream().filter(i -> ("" + i.getAvailability()).equals(queryValue)).collect(Collectors.toList());
            }
            break;
            case "city": {
                input = input.stream().filter(i -> i.getCity().equals(queryValue)).collect(Collectors.toList());
            }
            break;
            default: {
                input = new ArrayList<>();
            }
            break;
        }
        return input;
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public List<Item> getFiltered(MultivaluedMap<String, String> queries) {
        Iterator<String> it = queries.keySet().iterator();
        List<Item> allItems = itemRepository.getAllItems();


        while(it.hasNext()){
            String theKey = (String)it.next();
            String value = queries.getFirst(theKey);

            System.out.println("key: " + theKey + "value: " + value);
            allItems = filterQueries(allItems, theKey, value);
        }

        return allItems;
    }
}
