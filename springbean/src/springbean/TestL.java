package springbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import com.imooc.test.base.UnitTestBase;


@RunWith(BlockJUnit4ClassRunner.class)
public class TestL extends UnitTestBase {
		
	public TestL() {
		super("classpath:spring.xml");
	}
	
	@Test
	public void test1() {
		super.getBean("bean");
	}
		
}
