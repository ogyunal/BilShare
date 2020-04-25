package Item;
import java.io.*;
public class LectureNote 
{
  //properties
  private String relatedCourse;
  private String topic;
  private String additionalInfo;
  private double price;
  private File photo;
  private boolean sold;
  
  //constructor
  public LectureNote ( String topic, String relatedCourse,String additionalInfo, double price,
                      File photo)
  {
    this.topic = topic;
    this.relatedCourse = relatedCourse;
    this.additionalInfo = additionalInfo;
    this.price = price;
    this.photo = photo;
    sold = false;
  }
  
  //methods
  public void setPrice(double newPrice)
  {
    price = newPrice;
  }
  
  public String getTopic()
  {
    return topic;
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
  
  public File getPhoto()
  {
    return photo;
  }
  public String toString()
  {
    String lecturNoteInfo = "";
    lecturNoteInfo += "Topic: " +topic +"\nAdditional Info: " + additionalInfo + "\nPrice: " + price;
    return lecturNoteInfo;
    
  } 
}

