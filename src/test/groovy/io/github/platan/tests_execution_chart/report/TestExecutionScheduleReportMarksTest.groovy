package io.github.platan.tests_execution_chart.report

import spock.lang.Specification

import java.time.Instant

class TestExecutionScheduleReportMarksTest extends Specification {

    def "add mark with total time of all tests when report has many entries"() {
        given:
        def report = new TestExecutionScheduleReport([
                new TimedTestResult('class', 'test', toEpochMilli('2023-03-10T19:00:02Z'), toEpochMilli('2023-03-10T19:00:06Z'), 'passed'),
                new TimedTestResult('class', 'test', toEpochMilli('2023-03-10T19:00:03Z'), toEpochMilli('2023-03-10T19:00:07Z'), 'passed'),
        ])

        when:
        def resultWithMarks = report.addTotalTimeOfAllTestsMark('total time of all tests')

        then:
        resultWithMarks.results == report.results
        resultWithMarks.marks == [new Mark('total time of all tests', toEpochMilli('2023-03-10T19:00:10Z'))]
    }


    private static long toEpochMilli(String instant) {
        Instant.parse(instant).toEpochMilli()
    }
}
