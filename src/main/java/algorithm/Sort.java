package algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Title: Sort
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/7
 * @version 1.0
 * @since 1.0
 */
public class Sort {

	/**
	 * 冒泡 1..n
	 * @param arr
	 */
	public static void bubbleSort(int [] arr){
		checkNull(arr);

		for(int x = 0 ;x < arr.length ;x++){

			for(int y = x; y< arr.length-1 ;y++){

				if(arr[y] > arr[y+1]){
					swap(arr,y,y+1);
				}
			}
		}
	}

	/**
	 * 选择
	 * @param arr
	 */
	public static void selectSort(int [] arr){
		checkNull(arr);

		for(int x = 0 ;x < arr.length ;x++){

			for(int y = x; y< arr.length;y++){

				if(arr[x] > arr[y]){
					swap(arr,x,y);
				}
			}
		}
	}

	/**
	 * 插入
	 * @param arr
	 */
	public static void insertSort(int [] arr){
		checkNull(arr);

		for(int x = 1;x < arr.length ;x++){

			int target  = arr[x];
			int y = x;
			while(y > 0 && target < arr[y-1]){
				swap(arr,y-1,y);
				y--;
			}
			arr[y] = target;
		}
	}

	/**
	 * 快速
	 * @param arr
	 */
	public static void quickSort(int [] arr){
		checkNull(arr);







	}

	public static void quickSort0(int [] arr,int left ,int right){

	}




	public static void main(String[] args) throws IOException {
		int[] arr = new int[]{1,9,10,2,4,3,13,5,12};
		//bubbleSort(arr);
		//selectSort(arr);
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Math.pow(3,3));
		Properties p = new Properties();

	}

	/**
	 * 交换
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * 判断数组是否为空
	 * @param arr
	 */
	private static void checkNull(int [] arr){

		assert  (arr != null && arr.length > 0):"数组为空";

	}


}
