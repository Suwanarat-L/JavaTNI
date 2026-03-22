package UI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import FileManager.SubjectManager;
import Helpers_Renderers.SubjectRenderer;
import Helpers_Renderers.WindowHelper;
import Data.Subject;

public class SchedulePage {
    JPanel mainPanel;
    private JTable scheduleTable;
    private JButton add_buttom;
    private JButton delete_button;
    private JButton back_button;

    private SubjectManager subjectManager;

    public SchedulePage() {
        subjectManager = new SubjectManager(); //เรัยกใช้

        //สร้างตาราง
        String[] columns = {"Day/Time", "8:00-9:00", "9:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00"};
        DefaultTableModel tableModel = new DefaultTableModel(null, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            } //แก้ไม่ให้ไปมือบอนแก้ตารางเรียน
        };
        scheduleTable.setModel(tableModel);

        //ตกแต่งตาราง
        scheduleTable.setRowHeight(120);
        scheduleTable.getTableHeader().setBackground(new Color(43, 130, 212));
        scheduleTable.getTableHeader().setForeground(Color.WHITE);
        scheduleTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        scheduleTable.getTableHeader().setPreferredSize(new Dimension(100, 60));
        scheduleTable.setGridColor(new Color(220, 230, 240));
        scheduleTable.setSelectionBackground(Color.WHITE);
        scheduleTable.setDefaultRenderer(Object.class, new SubjectRenderer());

        refreshTable(); //รีเฟรชตาราง

        back_button.addActionListener(e -> {
            try {
                WindowHelper.switchWindow(back_button, new MainPage().MainPage, "Study Management System");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        add_buttom.addActionListener(e -> {
            String code = JOptionPane.showInputDialog("Enter Study Code (e.g. INT-108):");
            if (code == null || code.trim().isEmpty()) return; //ถ้าไม่ได้พิมพ์อะไรมา ก็จะโดนเตะออกจากกรอกข้อมูล

            String day;
            do {
                day = JOptionPane.showInputDialog("Enter Study Day (Monday-Friday):");
                if (day == null) return;
            } while (!day.equalsIgnoreCase("Monday") &&
                    !day.equalsIgnoreCase("Tuesday") &&
                    !day.equalsIgnoreCase("Wednesday") &&
                    !day.equalsIgnoreCase("Thursday") &&
                    !day.equalsIgnoreCase("Friday"));

            String startTime;
            boolean CheckSrt = false;
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            do {
                startTime = JOptionPane.showInputDialog("Enter Study Start Time (e.g. 09:00):");
                if (startTime == null || startTime.trim().isEmpty()) return;
                startTime = startTime.trim();
                try {
                    LocalTime.parse(startTime, timeFormatter);
                    CheckSrt = true;
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid time format!\nPlease enter valid time in HH:mm format.\nExample: 09:00 or 13:30",
                            "Time Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (!CheckSrt);

            String endTime;
            boolean CheckEnd = false;
            do {
                endTime = JOptionPane.showInputDialog("Enter Study End Time (e.g. 12:00):");
                if (endTime == null || endTime.trim().isEmpty()) return;
                endTime = endTime.trim();
                try {
                    LocalTime.parse(endTime, timeFormatter);
                    CheckEnd = true;
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid time format!\nPlease enter valid time in HH:mm format.\nExample: 09:00 or 13:30",
                            "Time Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (!CheckEnd);

            try {
                //แปลเป็นLocalTime
                LocalTime newStart = LocalTime.parse(startTime.trim());
                LocalTime newEnd = LocalTime.parse(endTime.trim());
                //ป้องกันคนกรอกพิเรน 12:00-09:00 / 10:00-10:00
                if (!newStart.isBefore(newEnd)) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid time duration!\nStart time must be before End time.",
                            "Logic Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; //เตะออกจากปุ่มaddทันทีไม่ให้เซฟ
                }

                //เช็คว่าเวลาชนกันไหม
                String checkTime = subjectManager.check(day, newStart, newEnd);
                if (!checkTime.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cannot add! Time overlaps with: " + checkTime,
                            "Time Conflict!", JOptionPane.ERROR_MESSAGE);
                } else {
                    //เซฟได้
                    subjectManager.addSubject(new Subject(code, day, startTime.trim(), endTime.trim()));
                    refreshTable();
                    JOptionPane.showMessageDialog(null, "Subject " + code + " added successfully!");
                }

            } catch (Exception ex) {
                System.out.println("Error adding subject: " + ex.getMessage());
                JOptionPane.showMessageDialog(null,
                        "An unexpected error occurred!",
                        "System Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        delete_button.addActionListener(e -> {
            String targetCode = JOptionPane.showInputDialog("Enter Study Code to Delete (e.g. INT-108):");
            if (targetCode != null && !targetCode.trim().isEmpty()) {
                boolean success = subjectManager.deleteSubject(targetCode);
                if (success) {
                    refreshTable();
                    JOptionPane.showMessageDialog(null, "Deleted successfully: " + targetCode);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot find subject: " + targetCode);
                }
            }
        });

        //ไว้กดจะดูข้อมูลในตาราง พอกดปุ๊ปก็จะแสดงข้อมูลในวิชานั้น
        scheduleTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = scheduleTable.rowAtPoint(e.getPoint());
                int col = scheduleTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col > 0) {
                    Object cellValue = scheduleTable.getModel().getValueAt(row, col);
                    String textData = (cellValue != null) ? cellValue.toString() : "";
                    if (!textData.trim().isEmpty()) {
                        String formattedText = textData.replace(" | ", "\n\n");
                        JOptionPane.showMessageDialog(null, "Subject Details:\n\n" + formattedText,
                                "Class Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    //รีเฟรชตาราง
    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
        model.setRowCount(0);

        //เคลียร์ตารางให้เป็นช่องว่างๆ
        String[][] emptyData = {
                {"Monday", "", "", "", "", "", "", "", "", "", ""},
                {"Tuesday", "", "", "", "", "", "", "", "", "", ""},
                {"Wednesday", "", "", "", "", "", "", "", "", "", ""},
                {"Thursday", "", "", "", "", "", "", "", "", "", ""},
                {"Friday", "", "", "", "", "", "", "", "", "", ""}
        };
        for (String[] rowData : emptyData) {
            model.addRow(rowData);
        }

        //เรียกวิชาออกมา
        Subject[] allSubjects = subjectManager.subjectAll();
        for (Subject s : allSubjects) {
            if (s != null) {
                int row = -1;

                //หาว่าวิชานี้อยู่แถวไหน
                if (s.getDay().equalsIgnoreCase("Monday")) row = 0;
                else if (s.getDay().equalsIgnoreCase("Tuesday")) row = 1;
                else if (s.getDay().equalsIgnoreCase("Wednesday")) row = 2;
                else if (s.getDay().equalsIgnoreCase("Thursday")) row = 3;
                else if (s.getDay().equalsIgnoreCase("Friday")) row = 4;

                //หาเวลา
                int startCol = s.getStartTime().getHour() - 7;
                int endCol = s.getEndTime().getHour() - 7;
                if (s.getEndTime().getMinute() > 0) endCol += 1;

                //เอาข้อมูลไปแปะลงตาราง
                if (row != -1 && startCol > 0) {
                    for (int c = startCol; c < endCol; c++) {
                        Object existingValue = model.getValueAt(row, c);
                        String existingText = (existingValue != null) ? existingValue.toString() : "";
                        String newText = s.getCode() + " (" + s.getStartTime() + "-" + s.getEndTime() + ")";

                        if (!existingText.isEmpty() && !existingText.equals(newText)) {
                            model.setValueAt(existingText + " | " + newText, row, c);
                        } else {
                            model.setValueAt(newText, row, c);
                        }
                    }
                }
            }
        }
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
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBackground(new Color(-1));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scheduleTable = new JTable();
        scheduleTable.setEditingColumn(-1);
        scheduleTable.setEditingRow(-1);
        scrollPane1.setViewportView(scheduleTable);
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        add_buttom = new JButton();
        add_buttom.setBackground(new Color(-13925676));
        Font add_buttomFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 15, add_buttom.getFont());
        if (add_buttomFont != null) add_buttom.setFont(add_buttomFont);
        add_buttom.setForeground(new Color(-1));
        add_buttom.setText("Add");
        panel1.add(add_buttom, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(160, 45), null, 0, false));
        delete_button = new JButton();
        delete_button.setBackground(new Color(-1618884));
        Font delete_buttonFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 15, delete_button.getFont());
        if (delete_buttonFont != null) delete_button.setFont(delete_buttonFont);
        delete_button.setForeground(new Color(-1));
        delete_button.setText("Delete");
        panel1.add(delete_button, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(160, 45), null, 0, false));
        back_button = new JButton();
        back_button.setBackground(new Color(-13925676));
        Font back_buttonFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 15, back_button.getFont());
        if (back_buttonFont != null) back_button.setFont(back_buttonFont);
        back_button.setForeground(new Color(-1));
        back_button.setText("Back");
        panel1.add(back_button, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(160, 45), null, 0, false));
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