import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Book> books = new ArrayList<>();
    public void Menu(){
        System.out.println("1. Novel");
        System.out.println("2. Album");
        System.out.println("Enter your choice: ");
    }

    public void ReadBooks(){
        Menu();
        String name;
        Integer noOfPages;
        Book b;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int choice = scanner1.nextInt();
        do{
            System.out.println("Enter the book name: ");
            name = scanner.nextLine();
            System.out.println("Enter the number of pages: ");
            noOfPages = scanner1.nextInt();
            if(choice == 1){
                System.out.println("Enter the type of novel: ");
                String type = scanner.nextLine();
                b = new Novel(name, noOfPages, type);
                books.add(b);
            }else{
                System.out.println("Enter the paper quality");
                String paperQuality = scanner.nextLine();
                b = new Album(name, noOfPages, paperQuality);
                books.add(b);
            }
            Menu();
            choice = scanner1.nextInt();
        }while (choice != 0);
    }

    public void AddBook(){
        System.out.println("Add a new book!");
        Menu();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        int choice = scanner1.nextInt();

        System.out.println("Enter the book name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the number of pages: ");
        int noOfPages = scanner1.nextInt();
        Book b;
        if(choice == 1){
            System.out.println("Enter the type of novel: ");
            String type = scanner.nextLine();
            b = new Novel(name, noOfPages, type);
        }else{
            System.out.println("Enter the type of album: ");
            String paperQuality = scanner.nextLine();
            b = new Album(name, noOfPages, paperQuality);
        }

        books.add(b);
    }

    public void DisplayBooks(){
        int counter = 0;
        for(Book aux : books){
            counter = counter + 1;
            if(aux instanceof Album){
                System.out.println("Book nr " + counter + " type of: Album");
                ((Album) aux).ShowAlbum();
            }else{
                System.out.println("Book nr " + counter + " type of: Novel");
                ((Novel) aux).ShowNovel();
            }
        }
    }
    public void DeleteBook(){
        System.out.println("Choose a book to delete it:");
        int counter = 0;
        for(Book b: books){
            counter = counter + 1;
            System.out.println(counter + b.getName());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        boolean ok = false;

        while(ok == false){
            if(choice >= books.size()){
                System.out.println("Index out of range!");
                System.out.println("Please select another index");
                counter = 0;
                for(Book b: books){
                    counter = counter + 1;
                    System.out.println(counter + b.getName());
                }
                choice = scanner.nextInt();
            }else{
                ok = true;
            }
        }

        books.remove(choice - 1);
        DisplayBooks();
    }

    public static  void main(String[] args){
        Main x = new Main();
        x.ReadBooks();
        x.DisplayBooks();

        x.AddBook();
        x.DisplayBooks();
        x.DeleteBook();
    }
}
