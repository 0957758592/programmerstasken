package ua.programmerstasken.analyzer.service;

import ua.programmerstasken.analyzer.entity.Query;
import ua.programmerstasken.analyzer.entity.TimeLine;

import java.time.LocalDate;
import java.util.List;

import static ua.programmerstasken.analyzer.utils.Constants.DASH;
import static ua.programmerstasken.analyzer.utils.Constants.STAR;

public class AnalyzeService {

    public static String[] analyze(List<TimeLine> timeLineList, List<Query> queryList) {
        int size = queryList.size();
        String[] response = new String[size];

        for (int i = 0; i < size; i++) {
            Query query = queryList.get(i);
            int matchesTimelineCount = 0;
            int totalTime = 0;

            for (TimeLine timeLine : timeLineList) {
                if (matchService(query.getService(), timeLine.getService()) &&
                        matchQuestion(query.getQuestionType(), timeLine.getQuestionType()) &&
                        matchAnswer(query.getAnswer(), timeLine.getAnswer()) &&
                        matchDate(query.getDateFrom(), query.getDateTo(), timeLine.getDate())) {
                    matchesTimelineCount++;
                    totalTime += timeLine.getTime();
                }
            }

            if (matchesTimelineCount == 0) {
                response[i] = DASH;
            } else {
                response[i] = String.valueOf(totalTime / matchesTimelineCount);
            }
        }

        return response;
    }

    private static boolean matchDate(LocalDate queryDateFrom, LocalDate dateTo, LocalDate date) {
        if (dateTo == null) {
            return queryDateFrom.equals(date);
        } else {
            return !queryDateFrom.isAfter(date) && !dateTo.isBefore(date);
        }
    }

    private static boolean matchAnswer(String queryAnswer, String timeLineAnswer) {
        return queryAnswer.equals(timeLineAnswer);
    }

    private static boolean matchQuestion(String queryQuestionType, String timeLineType) {
        return queryQuestionType.equals(STAR) || timeLineType.startsWith(queryQuestionType);
    }

    private static boolean matchService(String queryService, String timeLineService) {
        return queryService.equals(STAR) || timeLineService.startsWith(queryService);
    }

}
