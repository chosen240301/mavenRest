/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.carl.book;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author KarpovichA
 */
/*
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JSONBookMarshaller implements MessageBodyReader<Book>, MessageBodyWriter<Book>{

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return type == Book.class;
    }

    @Override
    public long getSize(Book t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(Book t, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out) throws IOException, WebApplicationException {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("title", t.getTitle())
                .add("pages", t.getPages()).build();

        DataOutputStream outputStream = new DataOutputStream(out);
        outputStream.writeBytes(jsonObject.toString());
    }

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return type == Book.class;
    }

    @Override
    public Book readFrom(Class<Book> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
        JsonReader jsonReader = Json.createReader(in);
        JsonObject jsonObject = jsonReader.readObject();
        System.out.println(jsonObject.toString());
        Book book = new Book();
        book.setTitle(jsonObject.getString("title"));
        book.setPages(jsonObject.getInt("pages"));
        return book;
    }

}
*/