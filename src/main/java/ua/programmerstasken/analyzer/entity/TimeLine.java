package ua.programmerstasken.analyzer.entity;

import java.time.LocalDate;

public class TimeLine {
    private String service;
    private String questionType;
    private String answer;
    private LocalDate date;
    private int time;


    public TimeLine(String service, String questionType, String answer, LocalDate date, int time) {
        this.service = service;
        this.questionType = questionType;
        this.answer = answer;
        this.date = date;
        this.time = time;
    }


    public String getService() {
        return service;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "TimeLine{" +
                "ua.programmerstasken.analyzer.service='" + service + '\'' +
                ", questionType='" + questionType + '\'' +
                ", answer='" + answer + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
