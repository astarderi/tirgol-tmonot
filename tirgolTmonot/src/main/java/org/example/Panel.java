package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Panel extends JPanel {
    private BufferedImage bufferedImage;
    private MyMouseListener myMouseListener;

    //יצירת בנאי לפאנל וקישור ללחיצות העכבר
    public Panel(int x, int y, int w, int h) {
        this.setBounds(x, y, w, h);
        this.setLayout(null);
        gradient();
        //קישור שמיעת הקליל בעכבר על הפאנל הנוכחי
        this.myMouseListener = new MyMouseListener(this);
        //יצירת פוקוס על הפאנל הנוכחי בלחיצות העכבר
        this.setFocusable(true);
        this.requestFocus(true);
        this.addMouseListener(this.myMouseListener);
    }

    //צביעת הלוח באופן מסודר וסדרתי לפי הגוונים - לא צביעה של צבע אחד
    public void gradient() {
        Random random = new Random();
        int red = random.nextInt(0, 120);
        int green = random.nextInt(0, 120);
        int blue = random.nextInt(0, 256);
        Color color = new Color(red, green, blue);
        this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        //וצביעת התמונה לפי צבע רנדומלי ושינוי ערכים באופן סדרתי
        for (int i = 0; i < this.bufferedImage.getWidth(); i++) {
            for (int j = 0; j < this.bufferedImage.getHeight(); j++) {
                this.bufferedImage.setRGB(i, j, color.getRGB());
                if (green + 2 < 256) {
                    green += 2;
                }
            }
            if (red + 2 < 256) {
                red += 2;
            }
            color = new Color(red, green, blue);
        }
    }

    //פונקציה שכל פעם מגרילה צבע ומחזירה אותו
    public Color randomColor(){
        Random random = new Random();
        int red = random.nextInt(0, 256);
        int green = random.nextInt(0, 256);
        int blue = random.nextInt(0, 256);
        Color color = new Color(red,green,blue);
        return color;
    }

    //פיינטקומפונסט מובנת בתוך פאנל ומטרתה לעזור איך לצייר בתמונה - ועליה אנחנו עושים שדרוג
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //על מנת לצייר את התמונה אנחנו צריכים לומר איפה אנחנו רוצים לצייר :
        //הערך הראשון זה איזה תמונה אנחנו רוצים לצייר, הערך השני והשלישי זה איזה מיקום אנחנו רוצים שיתחיל
        // והערך הרביעי והחמישי זה עד איפה אנחנו רוצים שהוא יצייר(לדוגמה עד האורך והרוחב של התמונה),
        g.drawImage(this.bufferedImage,0,0,this.bufferedImage.getWidth(),this.bufferedImage.getHeight(),null);

    }
}
