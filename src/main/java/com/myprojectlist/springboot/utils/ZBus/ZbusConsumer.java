package com.myprojectlist.springboot.utils.ZBus;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Consumer;

import java.io.IOException;

/**
 * 消费
 * @author: Levon
 * @version: v 0.1 2017-05-26 17:08
 */

public class ZbusConsumer extends Thread{




    private static Logger logger = LoggerFactory.getLogger(ZbusConsumer.class);

    private Broker broker;

    private boolean isstop = false;
    private IdWorker idWorker;

    private boolean comflag = false;

    private String imsi = "";
    private String serialno = "";
    private String mqName = null;

    //public static ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();

    public boolean isIsstop() {
		return isstop;
	}



	public void setIsstop(boolean isstop) {
		this.isstop = isstop;
	}


    /**
     * 运行入口
     * @param address
     * @param mqName
     * @param Service
     * @param <T>
     * @return
     */
	public <T> T  ZbusConsumer(String address,String mqName,T Service){
        logger.info("执行ZbusConsumer");
//        this.weChatBaseService = Service;
		this.mqName = mqName;
        idWorker = new IdWorker(1, 1);
    	try {
			init(address,mqName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Service;
    }

    /**
     * 执行消费者
     * @param address
     * @param mqName
     * @throws Exception
     */
    public void init(String address,String mqName) throws Exception {
        logger.info("执行init");
        Broker broker = new ZbusBroker(address);
        final Consumer c0 = new Consumer(broker, mqName);
        c0.setConsumerHandlerPoolSize(10);
        c0.setConsumerHandlerRunInPool(true);
        c0.start((message, consumer) -> {
            try {
                String jsonStr = message.getBodyString();
                logger.info(jsonStr);
                if(!StringUtils.isEmpty(jsonStr)){
//                    WeChatBase weChatBase = JSON.parseObject(jsonStr,WeChatBase.class);
//                    weChatBase.setId(UUID.randomUUID().toString().replaceAll("-", ""));
//                    weChatBase.setCreateDate(weChatBase.getCreateTime());
//                    weChatBaseService.save(weChatBase);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        });


    }

    //@PreDestroy
    public void destroy() {
        try {
            broker.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}