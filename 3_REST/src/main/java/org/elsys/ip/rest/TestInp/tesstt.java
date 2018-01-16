package org.elsys.ip.rest.TestInp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.elsys.ip.rest.model.Item;

import java.util.List;

@JsonSerialize
public class tesstt {
    private List<Item> items;

    private tesstt() {}

    public tesstt(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
