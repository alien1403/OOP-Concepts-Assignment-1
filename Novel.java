import javax.sound.midi.SysexMessage;

public class Novel extends Book{
    public String type;

    Novel(){
        type = "";
    }

    public String getType(){
        return type;
    }

    Novel(String name, Integer page, String type){
        super(name, page);
        this.type = type;
    }

    public void ShowNovel(){
        super.DisplayBook();
        System.out.println("Type: " + type);
    }
}
