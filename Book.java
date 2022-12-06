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
}
