package org.example.Library;

public class Book {
    String id;
    String title;
    String author;
    boolean isIssued;
    public Book(String id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        isIssued= false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }


    public void issue() {
        if (!isIssued) {
            isIssued = true;
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
        }
    }

    public void display() {
        System.out.println("ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Issued: " + isIssued);
    }



}
