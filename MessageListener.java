package com.redis;

import redis.clients.jedis.JedisPubSub;

public class MessageListener extends JedisPubSub {

	@Override
    public void onMessage(String channel, String message) {
        System.out.println("Recceived Message:" + message );
        System.out.println();
        if(message.equalsIgnoreCase("quit")){
            this.unsubscribe(channel);
        }
    }
    
}
