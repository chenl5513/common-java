import java.nio.ByteBuffer;

/**
 * Title: common
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2018/1/23
 * @version 1.0
 * @since 1.0
 */
public class common {


	public static void main(String[] args) {

		ByteBuffer bf = ByteBuffer.allocate(10);

		String str =  "哈哈哈";
		final byte[] bytes = str.getBytes();
		System.out.println(bytes.length);
		bf.put(bytes);
		bf.flip();
		bf.put(bytes);
		System.out.println(bf.position());
		System.out.println(bf.limit());
		System.out.println(bf.capacity());



	}
}
