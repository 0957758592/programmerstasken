package ua.programmerstasken.analyzer.entity;

import java.time.LocalDate;

public class Query {
    private String service;
    private String questionType;
    private String answer;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Query(String service, String questionType, String answer, LocalDate dateFrom) {
        this.service = service;
        this.questionType = questionType;
        this.answer = answer;
        this.dateFrom = dateFrom;
    }

    public Query(String service, String questionType, String answer, LocalDate dateFrom, LocalDate dateTo) {
        this.service = service;
        this.questionType = questionType;
        this.answer = answer;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return "Query{" +
                "ua.programmerstasken.analyzer.service='" + service + '\'' +
                ", questionType='" + questionType + '\'' +
                ", answer='" + answer + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
