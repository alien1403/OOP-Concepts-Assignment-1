import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public void Menu(){
        System.out.println("1. Novel");
        System.out.println("2. Album");
        System.out.println("Enter your choice: ");
    }

    public static  void main(String[] args){
        Main x = new Main();
        Book b;
        String name;
        Integer noOfPages;
        ArrayList<Book> books = new ArrayList<>();
        x.Menu();
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
            x.Menu();
            choice = scanner1.nextInt();
        }while (choice != 0);
    }
}
