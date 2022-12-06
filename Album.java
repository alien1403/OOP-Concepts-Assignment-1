public class Album extends Book {
    public String paperQuality;

    Album(){
        paperQuality = "";
    }

    Album(String name, Integer noOfPages, String paperQuality){
        super(name, noOfPages);
        this.paperQuality = paperQuality;
    }
}
