import java.util.ArrayList;
import java.util.Scanner;

public class Singleton {
    private static Singleton instance = null;

    ArrayList<Book> books = new ArrayList<>();

    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    public void displayOptions(){
        System.out.println("1. Novel");
        System.out.println("2. Album");
        System.out.println("Enter your choice: ");
    }
    public void showOptions(){
        System.out.println("---------Meniu---------");
        System.out.println("0. Read n books and display them");
        System.out.println("1. Display the books");
        System.out.println("2. Display a certain book");
        System.out.println("3. Add a new book");
        System.out.println("4. Delete a certain book");
        System.out.println("5. Exit");
    }

    public void addBooks(){

        String name;
        Integer noOfPages;
        Book b;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Number of books: ");
        int numberOfBooks = scanner1.nextInt();

        for(int i=0;i<numberOfBooks;i++){
            displayOptions();
            int choice = scanner1.nextInt();
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
        }
    }

    public void displayBooks(){
        int counter = 0;
        for(Book aux : books){
            counter = counter + 1;
            if(aux instanceof Album){
                System.out.println("Book nr " + counter + " type of: Album");
                ((Album) aux).showAlbum();
            }else {
                System.out.println("Book nr " + counter + " type of: Novel");
                ((Novel) aux).showNovel();
            }
        }
    }

    public void display(){
        int counter = 0;

        for(Book aux : books){
            counter += 1;
            System.out.println("Book " + counter + " name: " + aux.getName());
        }
    }

    public void displayBook(){
        display();
        Scanner scanner = new Scanner(System.in);
        boolean ok = true;
        while(ok == true){
            int index = scanner.nextInt();
            if(index - 1 >= books.size()){
                System.out.println("Wrong index");
                System.out.println("Add a valid index");
            }else {
                ok = false;
                int counter = -1;
                for(Book aux : books){
                    counter = counter + 1;
                    if(counter == index - 1){
                        if(aux instanceof Album){
                            ((Album) aux).showAlbum();
                        }else{
                            ((Novel) aux).showNovel();
                        }
                    }
                }
            }
        }
    }

    public void addBook(){
        System.out.println("Adauga o carte noua!");
        displayOptions();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        int choice = scanner1.nextInt();

        System.out.println("The book name: ");
        String name = scanner.nextLine();
        System.out.println("The number of pages: ");
        int noOfPages = scanner1.nextInt();
        Book b;
        if(choice == 1){
            System.out.println("Enter the type of novel: ");
            String type = scanner.nextLine();
            b = new Novel(name, noOfPages, type);
        }else{
            System.out.println("Enter the paper quality: ");
            String paperQuality = scanner.nextLine();
            b = new Album(name, noOfPages, paperQuality);
        }

        books.add(b);
    }

    public void deleteBook(){
        System.out.println("Select an index:");
        int counter = 0;
        for(Book b: books){
            counter = counter + 1;
            System.out.println(counter + ". " + b.getName());
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
        displayBooks();
    }
}
