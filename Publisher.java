package com.redis;

import redis.clients.jedis.Jedis;

public class Publisher {

	private Jedis jedis;
	
	public Publisher(String host, int port) {
		jedis = new Jedis(host, port);
	}
	
	public void publish(String message, String channel) {
		System.out.println("message published :"+ message);
		jedis.publish(channel, message);
		
	}
	
	public void closeChannel(String channel) {
		System.out.println("closing channel");
		jedis.publish(channel, "quit");
	}
}
