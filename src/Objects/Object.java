package Objects;

import java.awt.image.BufferedImage;

public class Object {
    private BufferedImage image;
    private int type;

    public Object(BufferedImage image, int type)
    {
        this.image = image;
        this.type = type;
    }


    public BufferedImage getImage() {
        return image;
    }

    public int getType() {
        return type;
    }
}
