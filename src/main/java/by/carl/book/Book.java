/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.carl.book;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KarpovichA
 */
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NamedQueries ({
    @NamedQuery (name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery (name = "Book.findAll", query = "SELECT b FROM Book b")
})
public class Book implements Serializable{

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", pages=" + pages + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Book() {
    }

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }
    @Id
    private String title;
    
    private int pages;
    
}
