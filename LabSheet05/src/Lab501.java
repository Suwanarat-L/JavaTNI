import javax.swing.*;
import java.text.DecimalFormat;

public class Lab501 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");
        int yes_no = JOptionPane.showConfirmDialog(null, "Do you want to check your BMI?","Check BMI", JOptionPane.YES_NO_OPTION);
        if (yes_no == JOptionPane.YES_OPTION){
            double weight = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter your weight (kg.):"));
            double height = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your height (cm.):"));
            double bmi = cal_bmi(weight,height);
            String bmi_result = check_bmi(bmi);
            JOptionPane.showMessageDialog(null,"Your BMI = " + df.format(bmi) +
                    "\nYour BMI result = " + bmi_result);
        }
        else JOptionPane.showMessageDialog(null,"END PROGRAM!!");
    }

    static double cal_bmi(double weight, double height_cm) {
        return weight/(Math.pow((height_cm/100),2)) ;
    }

    static String check_bmi(double bmi){
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Healthy Weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
}
