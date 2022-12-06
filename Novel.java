public class Novel extends Book{
    public String type;

    Novel(){
        type = "";
    }

    Novel(String name, Integer page, String type){
        super(name, page);
        this.type = type;
    }
}
