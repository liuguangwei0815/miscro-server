package com.misco.server;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * rocketmq 测试
 * 
 * @author liuwei
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MiscoOrderApplication.class)
public class ProducerAndConsumerTestClass {

	/**
	 * 测试pruduer 生产者
	 * 
	 * @throws MQClientException
	 * @throws UnsupportedEncodingException
	 * @throws RemotingException
	 * @throws MQBrokerException
	 * @throws InterruptedException
	 */
	@Test
	public void test1() throws MQClientException, UnsupportedEncodingException, RemotingException, MQBrokerException,
			InterruptedException {
		// 因为我们的生产和消费都是一个组 每个组默认有4个队列 所以我们在建立一个producer 需要指定组名
		DefaultMQProducer producer = new DefaultMQProducer("producer_group_cluster11");
		// 设置注册地址中心 nameserver
		//producer.setNamesrvAddr("192.168.2.168:9876");
		//切换成rocketmq的地址
		producer.setNamesrvAddr("192.168.2.168:9876;192.168.2.119:9876;192.168.2.148:9876;192.168.2.123:9876");
		// 开启当前生产者
		producer.start();
		/**
		 * String topic, String tags, String keys, byte[] body top:主题 tages：标识
		 * 用于特定的消息标识，通过这个tages 找到 keys:唯一标识，定位当前消息 body：消息
		 * 
		 */
		List<Message> ll = new ArrayList<Message>();
		for (int i = 0; i < 10; i++) {
			Message message = new Message("Topic_demo_cluster_1111", "Tags", "key_1", (i+"-我是集群消息哈哈哈").getBytes(RemotingHelper.DEFAULT_CHARSET));
			ll.add(message);
		}
		
		// 发送消息
		SendResult result = producer.send(ll);
		System.out.println("发送成功结果：" + result.toString());
		// 关闭
		producer.shutdown();
	}

	// 发送有序消息顺序，因为rocketmq 是随机发送到4个队列去的 无法保证全局的有序，如要向有序，需要自定需要发送到那个队列
	@Test
	public void test3() throws MQClientException, UnsupportedEncodingException, RemotingException, MQBrokerException,
			InterruptedException {
		// 因为我们的生产和消费都是一个组 每个组默认有4个队列 所以我们在建立一个producer 需要指定组名
		DefaultMQProducer producer = new DefaultMQProducer("producer_group");
		// 设置注册地址中心 nameserver
		producer.setNamesrvAddr("192.168.2.168:9876");
		// 开启当前生产者
		producer.start();
		/**
		 * String topic, String tags, String keys, byte[] body top:主题 tages：标识
		 * 用于特定的消息标识，通过这个tages 找到 keys:唯一标识，定位当前消息 body：消息
		 * 
		 */
		for (int i = 0; i < 5; i++) {
			Message message = new Message("Topic_demo", "Tags", "key_"+i,(":hellow"+i+"").getBytes(RemotingHelper.DEFAULT_CHARSET));
			// 发送消息
			/**
			 * MessageQueueSelector 发送的队列 arg： 队列下标
			 * 下面的语句的意思 时间消息发党我们主题的下标为1队列里
			 */
			SendResult result = producer.send(message, new MessageQueueSelector() {
				// 其中的方法里的arg 就是由send arg 参数决定的 ，mqs 这个是队列的范围，多少一般由你集群个数决定的 mqs=集群数量*4
				@Override
				public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
					return mqs.get((int) arg);
				}
			}, 1);
			System.out.println("发送成功结果：" + result.toString());
		}
		// 关闭
		producer.shutdown();
	}

	/**
	 * 测试consumer 消费者测试 ,这个在启动类也有一份
	 * 
	 * @throws MQClientException
	 */
	@Test
	public void test2() throws MQClientException {
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
		// 设置监听器 MessageListenerConcurrently 同时接受信息 非顺序接受
		consuper.setMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				// 获取消息
				for (MessageExt e : msgs) {
					try {
						System.out.printf("top:%s,tags:%s,message:%s", e.getTopic(), e.getTags(),
								new String(e.getBody(), RemotingHelper.DEFAULT_CHARSET));
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
						// 应答重试机制
						return ConsumeConcurrentlyStatus.RECONSUME_LATER;
					}
				}
				// 应答是否接受到新
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		// 开启消费者
		consuper.start();

	}

}
