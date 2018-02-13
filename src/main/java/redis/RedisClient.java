package redis;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

/**
 * Title: RedisClient
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/28
 * @version 1.0
 * @since 1.0
 */
public class RedisClient {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		Client client = jedis.getClient();
	}
}
