package com.bilshare.bilshare.bookstore.ui.signup.items;

import com.bilshare.bilshare.bookstore.ui.signup.data.AvatarImage;

public class Book
{
    //properties
    private String name;
    private String author;
    private int version;
    private String relatedCourse;
    private String additionalInfo;
    private double price;
    private AvatarImage photo;
    private boolean sold;

    //constructor
    public Book ( String name,String author ,int version, String relatedCourse, String additionalInfo, double price,
                  AvatarImage photo)
    {
        this.name = name;
        this.author = author;
        this.version = version;
        this.relatedCourse = relatedCourse;
        this.additionalInfo = additionalInfo;
        this.price = price;
        this.photo = photo;
        sold = false;
    }

    // method
    // public void setName(String name)
    // setAuthor()
    // setVersion()
    // setRelatedCourse()

    public void setPrice(double newPrice)
    {
        price = newPrice;
    }

    public String getName()
    {
        return name;
    }
    public String getAuthor()
    {
        return author;
    }

    public int getVersion()
    {
        return version;
    }

    public String getRelatedCourse()
    {
        return relatedCourse;
    }

    public double getPrice()
    {
        return price;
    }

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }

    public AvatarImage getPhoto()
    {
        return photo;
    }
    public String toString()
    {
        String bookInfo = "";
        bookInfo += "Name: " + name + "\nAuthor: " + author + "\nVersion: " + version + "\nAdditional Info: " +
                additionalInfo + "\nPrice: " + price;
        return bookInfo;

    }
}
