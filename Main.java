import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Singleton s = new Singleton();
        Scanner scanner = new Scanner(System.in);
        while(true){
            s.showOptions();
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();
            if(choice == 0)
                s.addBooks();
            else if(choice == 1)
                s.displayBooks();
            else if(choice == 2)
                s.displayBook();
            else if(choice == 3)
                s.addBook();
            else if (choice == 4)
                s.deleteBook();
            else if(choice == 5)
                break;
            else
                System.out.println("Wrong index");
        }
    }
}
