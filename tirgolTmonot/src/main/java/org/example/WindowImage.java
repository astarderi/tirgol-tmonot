//שינוי צבע תמונה לצבע הבהיר ביותר בתמונה



package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WindowImage extends JFrame {
    //שמירת התמונה בתוך המשתנה מיכל
private BufferedImage image;
//יצירת תווית להצגת התמונה בתוכה
private JLabel imageLabel;
    public WindowImage() {
        try {
            //שמירת נתיב התמונה בתוך המשתנה שבחרנו
            this.image = ImageIO.read(new File("src/main/java/org/example/הורדה.png"));
            //צביעת התמונה בעזרת הפונקציה בצבע הבהיר ביותר
            Color color = brighttest();
            paintImage(color);
            //השמת התמונה בתוך התווית
            this.imageLabel = new JLabel(new ImageIcon(this.image));
            //על מנת שהתוכנית לא תיפול עוטפים את התוכנית באקספשן -
            // נגיד אם אין את התמונה אז את התוכנית לא תקרוס ותמשיך לעבוד בלי התמונה
        } catch (IOException e) {
            e.printStackTrace();
        }
        //יצירת חלון לתמונה
        this.add(this.imageLabel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Color brighttest() {
        //יצירת משתנה לצבע
        Color color;
        //אם רוצים הכי בהיר המקס שווה לאפס ואם רוצים הכי כהה שווה ל755
        int max = 0;
        Color maxColor = null;
        //ריצה על כל פיקסל בתמונה , ריצה על כל הרוחב ועל כל האורך כמו במטריצה
        for (int x = 0; x < this.image.getWidth(); x++) {
            for (int y = 0; y < this.image.getHeight(); y++) {
                //השמת הצבע בפיקסל שכרגע נמצאים עליו בתוך משתנה COLOR
                color = new Color(this.image.getRGB(x, y));
                //הוצאת הערכים של הצבעים אדום ירוק וכחול
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int sumOfColor = red + green + blue;
                if (sumOfColor > max) {
                    max = sumOfColor;
                    //שמירת הערך של הצבע הכי בהיר שנדע מה הערכים של האדום ירוק וצהוב
                    maxColor = color;
                }
            }
        }
        return maxColor;
    }
    public void paintImage(Color color) {
        //שינוי התמונה לצבע הבהיר ביותר שמצאנו
        for (int x = 0; x < this.image.getWidth(); x++) {
            for (int y = 0; y < this.image.getHeight(); y++) {
                this.image.setRGB(x, y, color.getRGB());
            }
        }
    }
}
