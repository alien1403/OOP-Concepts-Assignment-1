public class Album extends Book {
    public String paperQuality;

    Album(){
        paperQuality = "";
    }

    public String getPaperQuality(){
        return paperQuality;
    }

    Album(String name, Integer noOfPages, String paperQuality){
        super(name, noOfPages);
        this.paperQuality = paperQuality;
    }

    public void ShowAlbum(){
        System.out.println("Name: " + name );
        System.out.println("Number of pages: " + numberOfPages);
        System.out.println("Paper Quality: " + paperQuality);
    }
}
