package com.simple;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Title: demo3
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/9/20
 * @version 1.0
 * @since 1.0
 */
public class demo3 {


	public static void main(String[] args) throws IOException {
		File file = new File("e:/1.txt");

		FileOutputStream fo = new FileOutputStream(file);
		FileInputStream fi = new FileInputStream(file);
		FileChannel channel = fo.getChannel();
		FileChannel channel1 = fi.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		String str= "哈哈哈啊哈哈";
		buffer.put(str.getBytes());
		buffer.flip();
		channel.write(buffer);
		buffer.clear();
		channel1.read(buffer);
		byte[] bytes = new byte[1024];

		System.out.println(new String(bytes));
		str= "我擦";
		buffer.put(str.getBytes());
		channel.close();
		fo.close();
	}

}
