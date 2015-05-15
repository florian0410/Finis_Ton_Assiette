package zlisproduction.finistonassiette.selectionaliments;

/**
 * Created by Florian on 15/05/2015.
 */
public class Aliment {
    /*
Un objet aliment contient un nom et une image
 */
    private String name;
    private int image;

    public Aliment(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
