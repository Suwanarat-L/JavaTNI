package Helpers_Renderers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

//โค้ดตกแต่งตารางเรียน
public class SubjectRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String currentText = (value != null) ? value.toString() : "";
        setHorizontalAlignment(SwingConstants.CENTER);

        if (column == 0) {
            setBackground(new Color(235, 245, 255));
            setFont(new Font("Segoe UI", Font.BOLD, 18));
            setForeground(new Color(50, 50, 50));
            return this;
        }

        if (!currentText.isEmpty()) {
            setBackground(new Color(175, 215, 250));
            setFont(new Font("Segoe UI", Font.BOLD, 16));
            setForeground(new Color(20, 60, 120));
            if (column > 1) {
                Object leftValue = table.getValueAt(row, column - 1);
                String leftText = (leftValue != null) ? leftValue.toString() : "";
                if (currentText.equals(leftText)) {
                    setText("");
                }
            }
        } else {
            setBackground(Color.WHITE);
        }
        return this;
    }
}