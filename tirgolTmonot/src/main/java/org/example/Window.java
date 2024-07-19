//החלפת צבעים של תמונה בלחיצה על העכבר



package org.example;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        //יצירת חלון
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //יצירת פאנל על הפריים (פריים מסגרת לתמונה)
        this.add(new Panel(0,0,500,500));
        this.setVisible(true);
    }
}
