

import spock.lang.*;
import com.example.log.demo.Calc
import com.hoge.spocktest.*;


class CalcSpec2 extends Specification{

    private Calc instance;

    def setup() {
        instance = new Calc()
    }

    def "２つの値の合計チェック"() {
        expect:
        instance.add(a, b) == c

        where:
        a | b | c
        1 | 3 | 4
        7 | 4 | 11
        0 | 0 | 0
    }
}