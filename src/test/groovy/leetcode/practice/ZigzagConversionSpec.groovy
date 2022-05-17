package leetcode.practice

import spock.lang.Specification

class ZigzagConversionSpec extends Specification {

    def "test algo"() {
        when:
        def result = new ZigzagConversion().convert(input, rowNum)
        then:
        result == expectedResult
        where:
        input            | rowNum || expectedResult
        "PAYPALISHIRING" | 3      || "PAHNAPLSIIGYIR"
        "PAYPALISHIRING" | 4      || "PINALSIGYAHRPI"
        "A"              | 1      || "A"
        "AB"             | 1      || "AB"
    }
}
