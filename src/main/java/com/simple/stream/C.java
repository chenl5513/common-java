package com.simple.stream;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Title: C
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/9/25
 * @version 1.0
 * @since 1.0
 */
public class C {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String num = scanner.next();
		int count=scanner.nextInt();
		cut(num,count);
	}

	public static String  cut(String nums ,int count){
		if(count == 0){
			System.out.print(nums);
			return nums;
		}
		for(int i =9 ;i >=0 ;i-- ){

			int index = nums.indexOf(i+"");
			if(index != -1){
				if(index <= count){
					count -= index;
					System.out.print(i);
					return cut(nums.substring(index+1),count);
				}

			}

		}

		return "";

	}


}
