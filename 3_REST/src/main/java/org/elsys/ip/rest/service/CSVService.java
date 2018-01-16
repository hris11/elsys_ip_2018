package org.elsys.ip.rest.service;

import com.opencsv.CSVWriter;
import org.elsys.ip.rest.model.Item;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVService {

    private ItemService itemService = new ItemService();

    public void updateFile(String path) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(path));
            List<Item> allItems = itemService.getAllItems();
            List<String[]> csv_data = new ArrayList<>();

            csv_data.add(
                    new String[] {
                            "id",
                            "name",
                            "desc",
                            "price",
                            "city",
                            "tags",
                            "color",
                            "price",
                            "score",
                            "brand",
                            "discount",
                            "availability",
                            "publish-date"
                    }
            );

            for (Item item : allItems) {
                csv_data.add(
                        new String[] {
                                "" + item.getId(),
                                item.getName(),
                                item.getDescription(),
                                "" + item.getPrice(),
                                item.getCity(),
                                item.getTags(),
                                item.getColor(),
                                "" + item.getPrice(),
                                "" + item.getScore(),
                                item.getBrand(),
                                "" + item.getDiscount(),
                                "" + item.getAvailability(),
                                "" + item.getPublishDate()
                        });
            }
            writer.writeAll(csv_data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void safeNewFile(InputStream inputStream, FormDataContentDisposition fileDetail) throws IOException {
        OutputStream os = new FileOutputStream("C:\\Users\\hrist\\Desktop\\Uploads\\" + fileDetail.getFileName());
        byte bytes[] = new byte[2048];
        int count = 0;
        while ((count = inputStream.read(bytes)) != -1) {
            os.write(bytes, 0, count);
        }
        os.flush();
        os.close();
    }
}
