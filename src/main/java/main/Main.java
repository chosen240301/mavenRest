/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import by.carl.book.Book;
//import by.carl.book.JSONBookMarshaller;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KarpovichA
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
//        client.register(JSONBookMarshaller.class);
        Response response = client.target("http://localhost:48921/mavenRest").path("/books/qwe").request().get();
        Book book = response.readEntity(Book.class);
        System.out.println(book);
        response = client.target("http://localhost:48921/mavenRest").path("/books/all").request().get();
        System.out.println(response.readEntity(new GenericType<ArrayList<Book>>() {}));

    }
}
