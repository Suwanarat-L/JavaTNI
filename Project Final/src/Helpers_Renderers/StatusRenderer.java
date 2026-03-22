package Helpers_Renderers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

//โค้ดระบายสีตารางการบ้าน
public class StatusRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String status = (value != null) ? value.toString() : "";
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Segoe UI", Font.BOLD, 14));

        if (status.equals("Completed")) {
            c.setBackground(new Color(46, 204, 113));
            c.setForeground(Color.WHITE);
        } else if (status.equals("Not Started")) {
            c.setBackground(new Color(231, 76, 60));
            c.setForeground(Color.WHITE);
        } else {
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);
        }
        return c;
    }
}