package com.testclass;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import java.util.HashSet;
import java.util.Set;
public class JedisClusterTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);
        Set<HostAndPort> jedisClusterNode = new HashSet();
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 8001));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 8002));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 8003));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 8004));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 8005));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 8006));
        //connectionTimeout：指的是连接一个url的连接等待时间
        //soTimeout：指的是连接上一个url，获取response的返回等待时间
        try (JedisCluster jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10, null, config)) {
            for (int i = 0; i < 10000; i++) {
                System.out.println(jedisCluster.set("clusterTest"+i, "song"+i));
            }
            for (int i = 0; i < 10000; i++) {
                System.out.println(jedisCluster.get("clusterTest"+i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
