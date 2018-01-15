package org.elsys.ip.rest.resource;

import org.elsys.ip.rest.model.Item;
import org.elsys.ip.rest.repository.ItemRepository;
import org.elsys.ip.rest.service.ItemService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Path("shop")
public class ItemResource {

    private ItemService itemService = new ItemService();

    @GET
    @Path("items")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getItems(@Context UriInfo uriInfo) {
        MultivaluedMap<String, String> queries = uriInfo.getQueryParameters();
        
        List<Item> allItems = itemService.getFiltered(queries);

        return allItems;
    }


}
