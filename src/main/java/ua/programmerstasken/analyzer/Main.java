package ua.programmerstasken.analyzer;

import ua.programmerstasken.analyzer.entity.Query;
import ua.programmerstasken.analyzer.entity.TimeLine;
import ua.programmerstasken.analyzer.service.AnalyzeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ua.programmerstasken.analyzer.utils.Constants.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int countLine = scanner.nextInt();
            scanner.nextLine();

            List<TimeLine> timeLineList = new ArrayList<>();
            List<Query> queryList = new ArrayList<>();

            for (int i = 0; i < countLine; i++) {
                String line = scanner.nextLine();
                if (line.startsWith(C)) {
                    TimeLine timeLine = parseTimeLine(line);
                    timeLineList.add(timeLine);
                } else {
                    Query query = parseQuery(line);
                    queryList.add(query);
                }
            }

            String[] result = AnalyzeService.analyze(timeLineList, queryList);
            for (String value : result) {
                System.out.println(value);
            }
        }
    }

    private static Query parseQuery(String line) {
        String[] arguments = line.split(SPACE);
        return arguments[4].contains(DASH) ?
                new Query(arguments[1], arguments[2], arguments[3], LocalDate.parse(arguments[4].split(DASH)[0], FORMATTER), LocalDate.parse(arguments[4].split(DASH)[1], FORMATTER)) :
                new Query(arguments[1], arguments[2], arguments[3], LocalDate.parse(arguments[4], FORMATTER));
    }

    private static TimeLine parseTimeLine(String line) {
        String[] arguments = line.split(SPACE);
        return new TimeLine(arguments[1], arguments[2], arguments[3], LocalDate.parse(arguments[4], FORMATTER), Integer.parseInt(arguments[5]));
    }
}

