package games;

/**
 *
 * @author Yashraj Balidani
 * @author Milind Jain
 * @version 1.0
 * 
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	private String image_path;
	private String heading_text;
	private String info_text;
	
	public ImageLoader(String img_path, String head_txt, String info_txt) {
		image_path = img_path;
		heading_text = head_txt;
		info_text = info_txt;
	}
	
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File("data" + path));

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;

    }

	public String getImage_path() {
		return image_path;
	}

	public String getHeading_text() {
		return heading_text;
	}

	public String getInfo_text() {
		return info_text;
	}
    
}
