/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import by.carl.book.Book;
import by.carl.book.Books;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KarpovichA
 */
@Path("books")
public class BookRestService {

    @Path("/{author}/{title}/{pages}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(@PathParam("author") String author, @PathParam("title") String title, @PathParam("pages") int pages) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("BookPU");
        EntityManager em = emf.createEntityManager();
        try {
            Book book = em.createNamedQuery("Book.findByAuthorAndTitle", Book.class)
                    .setParameter("author", author)
                    .setParameter("title", title)
                    .getSingleResult();
            return Response.notModified().build();
        } catch (NoResultException e) {
            Book book = new Book(author, title, pages);
            em.getTransaction().begin();
            em.persist(book);
            em.flush();
            em.getTransaction().commit();
            em.close();
            emf.close();
            return Response.ok(book).build();
        }
    }

    @GET
    @Path("/{author}/{title}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getBooksByAuthor(@PathParam("author") String author, @PathParam("title") String title) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("BookPU");
        EntityManager em = emf.createEntityManager();

        Book book = em.createNamedQuery("Book.findByAuthorAndTitle", Book.class)
                .setParameter("author", author)
                .setParameter("title", title)
                .getSingleResult();
        em.close();
        emf.close();
        return Response.ok(book).build();
    }

    @GET
    @Path("/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookByAuthorAndTitle(@PathParam("author") String author) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("BookPU");
        EntityManager em = emf.createEntityManager();

        Books books = new Books(em.createNamedQuery("Book.findByAuthor", Book.class)
                .setParameter("author", author)
                .getResultList());
        em.close();
        emf.close();
        return Response.ok(books).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("BookPU");
        EntityManager em = emf.createEntityManager();

        Books books = new Books(em.createNamedQuery("Book.findAll", Book.class).getResultList());
        em.close();
        emf.close();
        return Response.ok(books).build();
    }
}
