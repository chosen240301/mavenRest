/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.carl.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author KarpovichA
 */
@XmlRootElement(name = "book")
@XmlSeeAlso(Book.class)
public class Books extends ArrayList<Book> {

    public Books() {
        super();
    }

    public Books(Collection<? extends Book> c) {
        super(c);
    }

    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return this;
    }

    public void setBooks(List<Book> books) {
        this.addAll(books);
    }
}
