import javax.inject.Named;

@Named("hello")
public class Hello
{

    public String getWorld(){
        return "THIS WORKS NOW";
    }

}
