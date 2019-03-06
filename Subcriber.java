package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subcriber extends Thread {

	private Jedis jedis;
    private String channel;
    private JedisPubSub listener;
    
    public Subcriber(String host,int port){
        jedis = new Jedis(host,port);
    }
    
    public void setChannelAndListener(JedisPubSub listener,String channel){
        this.listener=listener;
        this.channel=channel;
    }
    private void subscribe(){
         System.out.println("subcribing Channel:"+channel);
        jedis.subscribe(listener, channel);
    }
    @ Override
    public void run() {
        try {
            subscribe ();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
