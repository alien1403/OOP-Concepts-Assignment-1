import java.util.Scanner;

public class Book {
    protected String name;
    protected Integer numberOfPages;

    Book(){
        name = "";
        numberOfPages = 0;
    }

    Book(String name, Integer numberOfPages){
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public String getName(){
        return name;
    }

    public Integer getNoOfPages(){
        return getNoOfPages();
    }

    public void setName(String name){
        this.name = name;
    }
    public  void setNumberOfPages(Integer numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    public void DisplayBook(){
        System.out.println("Book name: " + name);
        System.out.println("Number of pages: " + numberOfPages);
    }
}
