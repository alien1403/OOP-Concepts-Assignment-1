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

    public Book AddBook(){
        System.out.println("Add a new book!");
        System.out.println("1. Novel");
        System.out.println("2. Album");
        System.out.println("Choose the book type: ");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int choice = scanner1.nextInt();
        String name = scanner.nextLine();
        int noOfPages = scanner1.nextInt();
        Book b;
        if(choice == 1){
            String type = scanner.nextLine();
            b = new Novel(name, noOfPages, type);
        }else{
            String pageQuality = scanner.nextLine();
            b = new Album(name, noOfPages, pageQuality);
        }
        return b;
    }


}
