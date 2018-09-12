package com.almundo.back.business;

import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.almundo.back.agent.Agent;
import com.almundo.back.entities.Call;
import com.almundo.back.entities.EmployeeType;
import com.almundo.back.util.ConfigurationUtil;

/**
 * @author Carlos
 * @version 1.0
 * @created 12-sep.-2018 00:58:31
 */
public class Dispatcher {
	
	private static LinkedBlockingQueue<Runnable> qQueEmployees;
	private static ThreadPoolExecutor poolEmployees;
	
	public static ThreadPoolExecutor getThreadPoolExecutor() {
		return poolEmployees;
	}

	public Dispatcher() {
		int qMaxSizePool = Integer.valueOf(ConfigurationUtil.getInstance()
				.getProperty("callcenter.que.maxsizepool"));
		int qCoreSizePool = Integer.valueOf(ConfigurationUtil.getInstance()
				.getProperty("callcenter.que.coresizepool"));
		long qKeepAliveTime = Long.valueOf(ConfigurationUtil.getInstance()
				.getProperty("callcenter.que.keepalivetime"));
		
		qQueEmployees = new LinkedBlockingQueue<Runnable>();
		poolEmployees = new ThreadPoolExecutor(qCoreSizePool, qMaxSizePool, qKeepAliveTime, TimeUnit.SECONDS, qQueEmployees);

	}


	/**
	 * Manejador de las llamadas
	 * 
	 * @param call
	 * @throws InterruptedException 
	 */
	public void dispatchCall(Call call) throws InterruptedException {
		
		call.setTimeOfEntry(new Date());
		System.out.println(MessageFormat.format("Llamada entrante {0}, fecha: {1}", call.getIdCall(), call.getTimeOfEntry().toGMTString()));
		
		process(new Agent(call));
	}
	
	
	private void process(Agent agent) throws InterruptedException {
		poolEmployees.execute(agent);
		//poolEmployees.awaitTermination(1, TimeUnit.SECONDS);
	}

}