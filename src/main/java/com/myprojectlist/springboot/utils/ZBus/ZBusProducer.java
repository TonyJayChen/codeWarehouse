
package com.myprojectlist.springboot.utils.ZBus;

import com.alibaba.fastjson.JSON;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Producer;
import org.zbus.net.http.Message;

import java.io.IOException;

/**
 * Created by IBM on 2018/8/6.
 */

public class ZBusProducer {
    private Broker broker;
    private Producer p;

    /**
     * 启动生产者
     * @param address
     * @param brokerName
     */
    public ZBusProducer(String address,String brokerName){
    	try {
			init(address,brokerName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void init(String address,String brokerName) throws Exception{
        broker = new ZbusBroker(address);
        p = new Producer(broker, brokerName);
        p.createMQ();
    }

    /**
     * 生产者
     * @param t
     * @param <T>
     * @return
     */
    public <T> T Calling(T t){
        try {
            Message msg = new Message();
            System.out.println(JSON.toJSONString(t));
            msg.setBody(JSON.toJSONString(t));
            p.sendSync(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t ;
    }

    /**
     * 关闭
     */
    public void destroy() {
        try {
            broker.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//
//        WeChatBase weChatBase = new WeChatBase();
//        weChatBase.setNickName("不存在的。");
//        weChatBase.setCreateTime(System.currentTimeMillis());
//        weChatBase.setText("shjsakdjsaklhdjsakldhsakdhsal;h");
//        ZBusProducer zBusProducer = new ZBusProducer("localhost:15555","WECHAT_BASE_MSG");
//        zBusProducer.Calling(weChatBase);
//        System.exit(0);
//    }
}
