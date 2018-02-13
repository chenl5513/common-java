/**
 * Title: Test
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/12/18
 * @version 1.0
 * @since 1.0
 */
public class Test {

	public static void main(String[] args) {
		System.out.println(new Test.A().equals(new Test.B()) );

	}


	static class A{
		@Override
		public int hashCode() {
			return 1;
		}
	}
	static class B{
		public int hashCode() {
			return 1;
		}
	}
}
