package com.my.algorithm.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;

public class MegrSort {
	
	private static double temp [];
	public static void main(String[] args) throws Exception {

		String str = null;
		String fileName = "E:\\workspace\\sort\\200w.txt";
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		double data[] = new double[2100002];
		int i = 0;
		while ((str = br.readLine()) != null) {
			data[i++] = Double.valueOf(str);
		}
		System.out.println("数据读取完毕，size为" + i);
		long start = System.currentTimeMillis();
		// Arrays.sort(data);
		temp = new double[data.length];
		megerSort(data, 0, data.length - 1);
		System.out.println("归并消耗的时间为:" + (System.currentTimeMillis() - start) + "ms");
		File file = new File("E:\\workspace\\sort\\200w-msort.txt");
		Writer out = new FileWriter(file);
		for (i = 0; i < data.length; i++) {
			out.write(String.valueOf(data[i]) + "\r\n");
		}
		out.close();
		
		// System.out.println(Arrays.toString(data));
		// JDK里面的排序源码

	}

	public static void megerSort(double data[], int left, int right) { // 数组的两端
		if (left < right) {
			//System.out.println(left + ":" + right);
			int mid = (left + right) / 2;
			megerSort(data, left, mid);
			megerSort(data, mid + 1, right);
			meger(data, left, mid, right);
		}
	}

	public static void meger(double data[], int left, int mid, int right) {
		//System.out.println(left + ":" + right);
		//double temp[] = new double[data.length]; // 借助一个临时数组用来保存合并的数据

		int point1 = left; // 表示的是左边的第一个数的位置
		int point2 = mid + 1; // 表示的是右边的第一个数的位置

		int loc = left; // 表示的是我们当前已经到了哪个位置了
		while (point1 <= mid && point2 <= right) {
			if (data[point1] < data[point2]) {
				temp[loc++] = data[point1++];
			} else {
				temp[loc++] = data[point2++];
			}
		}
		while (point1 <= mid) {
			temp[loc++] = data[point1++];
		}
		while (point2 <= right) {
			temp[loc++] = data[point2++];
		}
		for (int i = left; i <= right; i++) {
			data[i] = temp[i];
		}
	}
}
