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

    public void DisplayOptions(){
        System.out.println("1. Novel");
        System.out.println("2. Album");
        System.out.println("Enter your choice: ");
    }
    public void showOptions(){
        System.out.println("---------Meniu---------");
        System.out.println("0. Citirea a n carti si afisarea lor");
        System.out.println("1. Afisarea cartilor");
        System.out.println("2. Afisarea informatiilor unei carti");
        System.out.println("3. Adaugarea unei carti");
        System.out.println("4. Stergerea unei carti");
        System.out.println("5. Exit");
    }

    public void AddBooks(){

        String name;
        Integer noOfPages;
        Book b;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Number of books: ");
        int numberOfBooks = scanner1.nextInt();

        for(int i=0;i<numberOfBooks;i++){
            DisplayOptions();
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

    public void DisplayBook(){
        Scanner scanner = new Scanner(System.in);
        boolean ok = true;
        while(ok == true){
            int index = scanner.nextInt();
            if(index >= books.size()){
                System.out.println("Index out of range!");
                System.out.println("Add a valid index");
                DisplayBooks();
                index = scanner.nextInt();
            }else {
                System.out.println("Da");
            }
        }
    }

    public void AddBook(){
        System.out.println("Add a new book!");
        DisplayOptions();
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
}
