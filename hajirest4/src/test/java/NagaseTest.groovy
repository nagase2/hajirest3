import static org.junit.Assert.*;

import org.bouncycastle.crypto.engines.NaccacheSternEngine;
import org.junit.Test;

import spock.lang.Specification;

import com.example.domain.Nagase;
import com.example.log.demo.Calc;


class NagaseTest extends Specification{

	private Nagase instance;
	
		def setup() {
			instance = new Nagase()
		}
	
		def "２つの値の合計チェック2"() {
			expect:
			instance.calc(a) == b
	
			where:
			a | b 
			3 | 9 
		}
}
