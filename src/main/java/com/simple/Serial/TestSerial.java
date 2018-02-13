package com.simple.Serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Title: TestSerial
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/9/13
 * @version 1.0
 * @since 1.0
 */
public class TestSerial {


	public static void main(String[] args) throws IOException {


		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("f:/"));
	}
}
