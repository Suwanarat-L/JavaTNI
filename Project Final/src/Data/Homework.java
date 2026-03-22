package Data;

public class Homework implements CommaValues {
    private String subject;
    private String detail;
    private String deadline;
    private String status;

    public Homework(String subject, String detail, String deadline, String status) {
        this.subject = subject;
        this.detail = detail;
        this.deadline = deadline;
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public String getDetail() {
        return detail;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String commaValues() {
        return subject + "," + detail + "," + deadline + "," + status;
    }
}