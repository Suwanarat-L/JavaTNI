package UI;

import Data.Subject;
import FileManager.SubjectManager;
import Helpers_Renderers.WindowHelper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class MainPage {
    JPanel MainPage;
    private JPanel menubutton;
    private JButton schedule_button;
    private JButton homework_button;
    private JButton grade_button;
    private JPanel deadlineToday;
    private JPanel datetime;
    private JPanel subjectNow;
    private JLabel date;
    private JLabel time;
    private JScrollPane header;
    private JTextArea taskTextArea;
    private JLabel studyNow;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JFrame frame;

    private final Subject[] todaySubjects;

    public MainPage() throws FileNotFoundException {
        frame = new JFrame();
        frame.setContentPane(MainPage);
        frame.setTitle("Study Management System");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1500, 900);
        frame.setLocationRelativeTo(null);

        //เปิดตารางเรียน
        SubjectManager course = new SubjectManager();
        todaySubjects = course.subjectAll();

        //แสดงเวลาตอนนี้
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); //จับรูปแบบเวลา
        Timer timer = new Timer(1000, e -> { //เครื่องเคาะเวลา 1000=1วิ
            time.setText(LocalTime.now().format(timeFormatter));
            //ทุก1วิข้อความตรงนาฬิกาจะเปลี่ยน
        });
        timer.start();

        //แสดงวันที่
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date.setText(LocalDate.now().format(dayFormatter));

        //แสดงวิชาที่กำลังเรียน
        Timer timer2 = new Timer(1000, e -> {
            String today = LocalDate.now().getDayOfWeek().toString(); //getDayOfWeek() ex. monday tuesday
            LocalTime timeNow = LocalTime.now();
            boolean isStudy = false;

            if (todaySubjects != null) {
                for (Subject s : todaySubjects) {
                    if (s != null && s.getDay().equalsIgnoreCase(today)) { //เช็ควันที่ของวิชา
                        if (!timeNow.isBefore(s.getStartTime()) && timeNow.isBefore(s.getEndTime())) { //เช็คเวลา
                            studyNow.setText("Studying: " + s.getCode());
                            isStudy = true;
                            break;
                        }
                    }
                }
            }
            if (!isStudy) studyNow.setText("No Class");
        });
        timer2.start();

        //แสดงการบ้านที่ต้องส่งวันนี้ พวกการบ้านของก่่อนวันนี้ก็จะเด้งด้วย
        StringBuilder textToShow = new StringBuilder(); //กระดาษทดสำหรับเขียนข้อความ เขียนไปเรื่อยๆจนเจอคำว่าsettextถึงจะเอาไปแสดงผลหน้าจอ
        boolean hasTaskToday = false;
        try {
            File hwFile = new File("src/homework.txt");
            if (hwFile.exists()) {
                Scanner scanner = new Scanner(hwFile);
                LocalDate todayDate = LocalDate.now();
                while (scanner.hasNextLine()) {
                    String[] parts = scanner.nextLine().split(",");
                    if (parts.length >= 4) {
                        String subject = parts[0].trim();
                        String detail = parts[1].trim();
                        String deadlineDate = parts[2].trim();
                        String status = parts[3].trim();
                        if (status.equals("Completed")) continue; //เบรกข้อมูลต่อจากนี้ แล้วไปทำบรรทัดต่อไป

                        try {
                            LocalDate deadline = LocalDate.parse(deadlineDate, dayFormatter);
                            if (deadline.isEqual(todayDate) || deadline.isBefore(todayDate)) {
                                textToShow.append("• ").append(detail).append(" (").append(subject).append(")\n");
                                hasTaskToday = true;
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                scanner.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (!hasTaskToday) textToShow.append("No homework due today");
        taskTextArea.setText(textToShow.toString()); //แสดงข้อความตรงช่องhomework

        frame.setVisible(true); //แสดงหน้าPage

        //เปลี่ยนไปหน้าอื่่น
        homework_button.addActionListener(e -> WindowHelper.switchWindow(homework_button, new HomeworkPage().mainPanel, "Homework"));
        schedule_button.addActionListener(e -> WindowHelper.switchWindow(schedule_button, new SchedulePage().mainPanel, "Schedule"));
        grade_button.addActionListener(e -> WindowHelper.switchWindow(grade_button, new GradePage().mainPanel, "Grade"));
    }

    public static void main(String[] args) throws FileNotFoundException {
        new MainPage();
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
        MainPage = new JPanel();
        MainPage.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        MainPage.setBackground(new Color(-1));
        menubutton = new JPanel();
        menubutton.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        menubutton.setBackground(new Color(-1313285));
        menubutton.setEnabled(true);
        MainPage.add(menubutton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, 900), null, 0, false));
        schedule_button = new JButton();
        schedule_button.setBackground(new Color(-13991206));
        Font schedule_buttonFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 20, schedule_button.getFont());
        if (schedule_buttonFont != null) schedule_button.setFont(schedule_buttonFont);
        schedule_button.setForeground(new Color(-1));
        schedule_button.setText("Schedule");
        menubutton.add(schedule_button, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 60), null, 0, false));
        homework_button = new JButton();
        homework_button.setBackground(new Color(-13991206));
        Font homework_buttonFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 20, homework_button.getFont());
        if (homework_buttonFont != null) homework_button.setFont(homework_buttonFont);
        homework_button.setForeground(new Color(-1));
        homework_button.setText("Homework");
        menubutton.add(homework_button, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 60), null, 0, false));
        grade_button = new JButton();
        grade_button.setBackground(new Color(-13991206));
        Font grade_buttonFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 20, grade_button.getFont());
        if (grade_buttonFont != null) grade_button.setFont(grade_buttonFont);
        grade_button.setForeground(new Color(-1));
        grade_button.setText("Grade");
        menubutton.add(grade_button, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 60), null, 0, false));
        subjectNow = new JPanel();
        subjectNow.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        subjectNow.setBackground(new Color(-1));
        MainPage.add(subjectNow, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(625, 250), null, 0, false));
        subjectNow.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-14575885)), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, -1, subjectNow.getFont()), new Color(-3025959)));
        studyNow = new JLabel();
        Font studyNowFont = this.$$$getFont$$$("Tahoma", -1, 48, studyNow.getFont());
        if (studyNowFont != null) studyNow.setFont(studyNowFont);
        studyNow.setForeground(new Color(-13421773));
        studyNow.setText("No Class");
        subjectNow.add(studyNow, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deadlineToday = new JPanel();
        deadlineToday.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        MainPage.add(deadlineToday, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(1250, 600), null, 0, false));
        header = new JScrollPane();
        header.setBackground(new Color(-2692360));
        Font headerFont = this.$$$getFont$$$("Tahoma", Font.BOLD, 25, header.getFont());
        if (headerFont != null) header.setFont(headerFont);
        header.setForeground(new Color(-15132132));
        deadlineToday.add(header, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        header.setBorder(BorderFactory.createTitledBorder(null, "Homework due today", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        taskTextArea = new JTextArea();
        taskTextArea.setBackground(new Color(-1));
        Font taskTextAreaFont = this.$$$getFont$$$("Tahoma", -1, 18, taskTextArea.getFont());
        if (taskTextAreaFont != null) taskTextArea.setFont(taskTextAreaFont);
        taskTextArea.setText("");
        header.setViewportView(taskTextArea);
        datetime = new JPanel();
        datetime.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        datetime.setBackground(new Color(-1));
        MainPage.add(datetime, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(625, 250), null, 0, false));
        date = new JLabel();
        Font dateFont = this.$$$getFont$$$("Tahoma", -1, 48, date.getFont());
        if (dateFont != null) date.setFont(dateFont);
        date.setForeground(new Color(-13421773));
        date.setText("dd/MM/yyyy");
        datetime.add(date, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        time = new JLabel();
        Font timeFont = this.$$$getFont$$$("Tahoma", -1, 48, time.getFont());
        if (timeFont != null) time.setFont(timeFont);
        time.setForeground(new Color(-13421773));
        time.setText("");
        datetime.add(time, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return MainPage;
    }
}