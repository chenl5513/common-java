package springtest.aop;

/**
 * Title: IMath
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/12/12
 * @version 1.0
 * @since 1.0
 */
public interface IMath {
	//加
	int add(int n1, int n2);

	//减
	int sub(int n1, int n2);

	//乘
	int mut(int n1, int n2);

	//除
	Integer div(int n1, int n2);

	//绝对值
	String abs(int n);
}
