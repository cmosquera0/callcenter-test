package com.almundo.back.business.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.almundo.back.business.Dispatcher;
import com.almundo.back.entities.Call;

public class DispatcherTest {
	
	//@Test
	public void TestCallOK() throws InterruptedException {
		Call call = new Call();
		call.setIdCall(123456789);
		
		Dispatcher manager = new Dispatcher();
		
		manager.dispatchCall(call);
	}
	
	@Test
	public void TestCall2() throws InterruptedException {
		Call call = new Call();
		call.setIdCall(123456789);
		
		Call call2 = new Call();
		call2.setIdCall(987);
		
		Dispatcher manager = new Dispatcher();
		
		manager.dispatchCall(call);
		Thread.sleep(1000);
		manager.dispatchCall(call2);
	}
	
	@Test
	public void TestCallMultiple() throws InterruptedException {
		Call call1 = new Call();
		call1.setIdCall(1);
		
		Call call2 = new Call();
		call2.setIdCall(2);
		
		Call call3 = new Call();
		call3.setIdCall(3);
		
		Call call4 = new Call();
		call4.setIdCall(4);
		
		Call call5 = new Call();
		call5.setIdCall(5);
		
		Call call6 = new Call();
		call6.setIdCall(6);
		
		Call call7 = new Call();
		call7.setIdCall(7);
		
		Call call8 = new Call();
		call8.setIdCall(8);
		
		Call call9 = new Call();
		call9.setIdCall(9);
		
		Call call10 = new Call();
		call10.setIdCall(10);
		
		Call call11 = new Call();
		call11.setIdCall(11);
		
		Dispatcher manager = new Dispatcher();
		
		manager.dispatchCall(call1);
		manager.dispatchCall(call2);
		manager.dispatchCall(call3);
		manager.dispatchCall(call4);
		manager.dispatchCall(call5);
		manager.dispatchCall(call6);
		manager.dispatchCall(call7);
		manager.dispatchCall(call8);
		manager.dispatchCall(call9);
		manager.dispatchCall(call10);
		manager.dispatchCall(call11);
		
		manager.getThreadPoolExecutor(). shutdown();
		manager.getThreadPoolExecutor().awaitTermination(20, TimeUnit.SECONDS);
		
	}


}
