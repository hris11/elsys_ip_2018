package org.elsys.ip.rest.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.elsys.ip.rest.model.Item;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
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
        OutputStream os = new FileOutputStream("C:\\Users\\hrist\\Desktop\\Uploads\\upload.csv");
        byte bytes[] = new byte[2048];
        int count = 0;
        while ((count = inputStream.read(bytes)) != -1) {
            os.write(bytes, 0, count);
        }
        os.flush();
        os.close();

        try (
                Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\hrist\\Desktop\\Uploads\\upload.csv"));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                itemService.insert(new Item (
                        Integer.valueOf(nextRecord[0]),
                        nextRecord[1],
                        Integer.valueOf(nextRecord[3]),
                        nextRecord[2],
                        nextRecord[6],
                        Integer.valueOf(nextRecord[10]),
                        nextRecord[9],
                        new Date(),
                        Integer.valueOf(nextRecord[8]),
                        nextRecord[5],
                        Integer.valueOf(nextRecord[11]),
                        nextRecord[4]
                        )
                );
                System.out.println("id : " + nextRecord[0]);
                System.out.println("name : " + nextRecord[1]);
                System.out.println("desc : " + nextRecord[2]);
                System.out.println("price : " + nextRecord[3]);
                System.out.println("city : " + nextRecord[4]);
                System.out.println("tags : " + nextRecord[5]);
                System.out.println("color : " + nextRecord[6]);
                System.out.println("price : " + nextRecord[7]);
                System.out.println("score : " + nextRecord[8]);
                System.out.println("brand : " + nextRecord[9]);
                System.out.println("discount : " + nextRecord[10]);
                System.out.println("availability : " + nextRecord[11]);
                System.out.println("publishDate : " + nextRecord[12]);
                System.out.println("==========================");
            }
        }
    }
}
