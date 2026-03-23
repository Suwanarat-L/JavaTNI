package Data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Subject implements CommaValues {
    private String code;
    private String day;
    //ใช้LocalTimeเพราะเปรียบเทียบง่ายกว่าใช้String
    private LocalTime startTime;
    private LocalTime endTime;

    public Subject(String code, String day, String startTimeStr, String endTimeStr) {
        this.code = code;
        this.day = day;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTimeStr.trim(), formatter);
        this.endTime = LocalTime.parse(endTimeStr.trim(), formatter);
    }

    public String getCode() { return code; }
    public String getDay() { return day; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }

    @Override
    public String commaValues() {
            return code + "," + day + "," + startTime.toString() + "," + endTime.toString();
    }
}