package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class ChatApplication {

	public static void main(String[] args) throws InterruptedException {

		String redisHost = "localhost";
		int redisPort = 6379;
		String channel = "test_channel";
		Jedis jedis = new Jedis(redisHost, redisPort);
		Publisher publisher = new Publisher(redisHost, redisPort);
		Subcriber subscriber = new Subcriber(redisHost, redisPort);
		JedisPubSub listener = new MessageListener();
		subscriber.setChannelAndListener(listener, channel);
		subscriber.start();
		
		for(int i=0;i<10;i++) {
			
			publisher.publish(String.valueOf(Math.random()), channel);
			Thread.sleep(1000);
		}
		publisher.publish("quit", channel);
		//subscriber.unsubscribe(channel);
		Thread.sleep(1000);
		
		for(int i=0;i<10;i++) {
			publisher.publish(String.valueOf(Math.random()), channel);
			Thread.sleep(1000);
		}
	}
}
