/**
 * 
 */
package com.misco.server;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
public class MiscoOrderApplication implements CommandLineRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoOrderApplication.class, args);
	}

	/**
	 * 普通接受
	 */
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("执行监听");
//		// 因为消费组也是一个集群 所以需要配置一个组名
//		DefaultMQPushConsumer consuper = new DefaultMQPushConsumer("default_consumer_mq");
//		// 设置注册中心
//		consuper.setNamesrvAddr("192.168.2.168:9876");
//		// 设置默认接受信息为32条
//		consuper.setConsumeMessageBatchMaxSize(2);// 设置最大能接受2条
//		// 监听主题
//		// top 对应生产者定义的主题 ，subExpression:对应生产端的producer tags ，* 带包所有 ，如上面的producer
//		// “Tags” ， 多个对的化使用 Tags || TagsA || TagsB
//		consuper.subscribe("Topic_demo", "*");
//		// 设置监听器 MessageListenerConcurrently 同时接受信息 非顺序接受
//		consuper.setMessageListener(new MessageListenerConcurrently() {
//			@Override
//			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//				// 获取消息
//				for (MessageExt e : msgs) {
//					try {
//						System.out.println("top:" + e.getTopic() + ",tags" + e.getTags() + ",message:"
//								+ new String(e.getBody(), RemotingHelper.DEFAULT_CHARSET));
//					} catch (UnsupportedEncodingException e1) {
//						e1.printStackTrace();
//						// 应答重试机制
//						return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//					}
//				}
//				// 应答是否接受到新
//				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//			}
//		});
//		// 开启消费者
//		consuper.start();
//		//
//		System.out.println("获取完毕");
//	}
	/**
	 * 有序消费
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("有序执行监听");
		// 因为消费组也是一个集群 所以需要配置一个组名
		DefaultMQPushConsumer consuper = new DefaultMQPushConsumer("default_consumer_mq");
		// 设置注册中心
		consuper.setNamesrvAddr("192.168.2.168:9876");
		// 设置默认接受信息为32条
		consuper.setConsumeMessageBatchMaxSize(2);// 设置最大能接受2条
		// 监听主题
		// top 对应生产者定义的主题 ，subExpression:对应生产端的producer tags ，* 带包所有 ，如上面的producer
		// “Tags” ， 多个对的化使用 Tags || TagsA || TagsB
		consuper.subscribe("Topic_demo", "*");
		// 有序消费
		consuper.setMessageListener(new MessageListenerOrderly() {
			@Override
			public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
				// 获取消息
				for (MessageExt e : msgs) {
					try {
						System.out.println("top:" + e.getTopic() + ",tags" + e.getTags() + ",message:"
								+ new String(e.getBody(), RemotingHelper.DEFAULT_CHARSET));
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
						// 应答重试机制
						return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
					}
				}
				// 应答是否接受到新
				return ConsumeOrderlyStatus.SUCCESS;

			}
		});
		// 开启消费者
		consuper.start();
		//
		System.out.println("获取完毕");
	}

}
