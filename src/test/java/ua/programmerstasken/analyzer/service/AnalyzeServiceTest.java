package ua.programmerstasken.analyzer.service;

import org.junit.Test;
import ua.programmerstasken.analyzer.entity.Query;
import ua.programmerstasken.analyzer.entity.TimeLine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnalyzeServiceTest {

    @Test
    public void testAnalyze() {
        //prepare
        List<TimeLine> timeLineList = new ArrayList<>();
        timeLineList.add(new TimeLine("1.15", "2.4", "P", LocalDate.of(2019, 10, 3), 100));
        timeLineList.add(new TimeLine("1.15", "2.4", "P", LocalDate.of(2019, 12, 6), 50));
        timeLineList.add(new TimeLine("1.15", "1.4", "P", LocalDate.of(2019, 10, 3), 100));

        List<Query> queryList = new ArrayList<>();
        queryList.add(new Query("1", "2.4", "P", LocalDate.of(2019, 9, 3), LocalDate.of(2019, 12, 15)));
        queryList.add(new Query("1.15", "2.4", "P", LocalDate.of(2019, 8, 3), LocalDate.of(2019, 9, 3)));
        queryList.add(new Query("1", "1", "P", LocalDate.of(2019, 10, 3)));

        //when
        String[] result = AnalyzeService.analyze(timeLineList, queryList);

        //then
        assertEquals("Should be equal", "75", result[0]);
        assertEquals("Should be equal", "-", result[1]);
        assertEquals("Should be equal", "100", result[2]);
    }
}
