package leetcode.practice

import spock.lang.Specification

class ThreeSumClosestSpec extends Specification {

    def "test algo"() {
        when:
        def result = new ThreeSumClosest().threeSumClosest(input, target)
        then:
        result == expectedResult
        where:
        input                   | target || expectedResult
        new int[]{
                -860, 21, -174, -816, 265, 492, 509, 757, 339, -831, 266, -652, -975, -626, -558, 536,
                -623, -340, -670, 741, 908, 434, -23, -186, -306, 506, 394, -849, 927, 610, -619, 774,
                893, 329, -980, 140, -257, -375, 228, -56, -663, -747, -684, 807, 218, -187, -380,
                843, -864, 569, 368
        }                       | -354   || -354
        new int[]{-1, 2, 1, -4} | 1      || 2
    }
}
