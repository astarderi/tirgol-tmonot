package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//יצירת מחלקה לעכבר והפעלת האימפלמנט של המחלקה היורשת
public class MyMouseListener implements MouseListener {

    //יצירת משתנה לפאנל על מנת לה גישה לפונקציה
    private Panel panel;
    public MyMouseListener(Panel panel){
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.panel.gradient();
        //על מנת שיראו את השינוי צריך לרשום את השורה הבאה
        this.panel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
