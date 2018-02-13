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


		int a = 0;
		int b = (200!=(a=200))?a:300;
		System.out.println(  a!=(a=200)  );
		System.out.println(b);

	}
}
