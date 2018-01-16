package org.elsys.ip.rest.resource;

import org.elsys.ip.rest.service.CSVService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Date;

@Path("csv")
public class CSVResource {

    private CSVService csvService = new CSVService();

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void upload(@FormDataParam("file") InputStream inputStream,
                       @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {
        csvService.safeNewFile(inputStream, fileDetail);
    }

    @GET
    @Path("/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadTest() throws IOException {

        String path = "C:\\Users\\hrist\\Desktop\\Uploads\\download.csv";

        File file = new File(path);
        file.createNewFile();

        csvService.updateFile(path);

        return Response
                .ok(file)
                .header("Content-Disposition", "attachment; filename=" + file.getName())
                .build();
    }
}
