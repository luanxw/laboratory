package com.app.luan;

import com.app.luan.handler.byInterface.Factory;
import com.app.luan.handler.byInterface.Handler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuanApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void TestFacory(){
		String worker = "luan";
		Handler invokeStrategy = Factory.getInvokeStrategy(worker);
		invokeStrategy.doWork(worker);
	}

	@Test
	public void TestFacetory1(){
		String worker = "luan";
		com.app.luan.handler.byAbstarctClass.Handler handler = com.app.luan.handler.byAbstarctClass.Factory.getstarteHandler(worker);
		handler.doWork(worker);
		String result = handler.doWorkOtherthings(worker);
		System.out.println(result);
	}
}
