package UI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import FileManager.HomeworkTableModel;
import Helpers_Renderers.StatusRenderer;
import Helpers_Renderers.WindowHelper;

public class HomeworkPage {
    JPanel mainPanel;
    private JButton add_button;
    private JButton back_button;
    private JTable homeworkTable;
    private JPanel button;

    public HomeworkPage() {
        //ตกแต่งตาราง
        HomeworkTableModel tableModel = new HomeworkTableModel();
        homeworkTable.setModel(tableModel);
        homeworkTable.setRowHeight(55);
        homeworkTable.getTableHeader().setBackground(new Color(43, 130, 212));
        homeworkTable.getTableHeader().setForeground(Color.WHITE);
        homeworkTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        homeworkTable.getTableHeader().setPreferredSize(new Dimension(100, 50));
        homeworkTable.setGridColor(new Color(220, 230, 240));
        homeworkTable.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        homeworkTable.getColumnModel().getColumn(3).setCellRenderer(new StatusRenderer());

        back_button.addActionListener(e -> {
            try {
                WindowHelper.switchWindow(back_button, new MainPage().MainPage, "Study Management System");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        add_button.addActionListener(e -> {
            String subject = JOptionPane.showInputDialog("Subject:");
            if (subject == null || subject.trim().isEmpty()) return;

            String detail = JOptionPane.showInputDialog("Detail:");
            if (detail == null || detail.trim().isEmpty()) return;

            String deadline;
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            do {
                deadline = JOptionPane.showInputDialog("Deadline (20/03/2026):");
                if (deadline == null || deadline.trim().isEmpty()) return;
                deadline = deadline.trim();
                try {
                    //แปลเป็นLocalDate
                    LocalDate.parse(deadline, dateFormatter);
                    break; //ถ้าแปลได้ก็เบรก

                } catch (DateTimeParseException ex) {
                    //ถ้าแปลไม่ได้
                    JOptionPane.showMessageDialog(null,
                            "Invalid date!\nPlease enter a valid date in dd/MM/yyyy format.\nExample: 25/03/2026",
                            "Date Error",
                            JOptionPane.ERROR_MESSAGE);

                    deadline = ""; //รีเซ็ต แล้วถามใหม่
                }
            } while (deadline.isEmpty());

            tableModel.addRow(new Object[]{subject.trim(), detail.trim(), deadline.trim(), "Not Started"}); //Addลงตาราง


        });

        //ไว้กดเปลี่ยนสถานะของการบ้าน
        homeworkTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = homeworkTable.rowAtPoint(e.getPoint());
                int col = homeworkTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col == 3) {
                    String currentStatus = homeworkTable.getValueAt(row, col).toString();
                    if (currentStatus.equals("Not Started")) {
                        if (JOptionPane.showConfirmDialog(null, "Are you sure you have completed this task?") == JOptionPane.YES_OPTION) {
                            tableModel.setValueAt("Completed", row, col);
                        }
                    } else if (currentStatus.equals("Completed")) {
                        if (JOptionPane.showConfirmDialog(null, "Change status back to 'Not Started'?") == JOptionPane.YES_OPTION) {
                            tableModel.setValueAt("Not Started", row, col);
                        }
                    }
                }
            }
        });

        //ไว้กดลบวิชา
        homeworkTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = homeworkTable.rowAtPoint(e.getPoint());
                int col = homeworkTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col == 0) {
                    String subjectName = tableModel.getValueAt(row, 0).toString();
                    String detail = tableModel.getValueAt(row, 1).toString();
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete this homework?\n[" + subjectName + "] " + detail,
                            "Delete Confirmation",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(row);
                    }
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        homeworkTable = new JTable();
        scrollPane1.setViewportView(homeworkTable);
        button = new JPanel();
        button.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(button, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        add_button = new JButton();
        add_button.setBackground(new Color(-13925676));
        Font add_buttonFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 15, add_button.getFont());
        if (add_buttonFont != null) add_button.setFont(add_buttonFont);
        add_button.setForeground(new Color(-1));
        add_button.setText("Add");
        button.add(add_button, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(160, 45), null, 0, false));
        back_button = new JButton();
        back_button.setBackground(new Color(-13925676));
        Font back_buttonFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 15, back_button.getFont());
        if (back_buttonFont != null) back_button.setFont(back_buttonFont);
        back_button.setForeground(new Color(-1));
        back_button.setText("Back");
        button.add(back_button, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(160, 45), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}