package Helpers_Renderers;

import javax.swing.*;
import java.awt.*;

//ไว้สลับหน้าจอ
//สาเหตุเที่มี เขียนเยอะเลยแยกออกมา
public class WindowHelper {
    public static void switchWindow(JButton triggerButton, JPanel newPanel, String title) {
        JFrame newFrame = new JFrame(title);
        newFrame.setContentPane(newPanel);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(1500, 900);
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);

        //ลบหน้าเดิมทิ้งหลังจากกดปุ่ม
        Window currentWindow = SwingUtilities.getWindowAncestor(triggerButton);
        if (currentWindow != null) {
            currentWindow.dispose();
        }
    }
}