package tl.algorithm.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {
	public static void main(String[] args) {
		int datasize = 100000000;	//我们要插入的数据也就是n
		double fpp = 0.001;		//0.1%	误判率
		
		BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), datasize, fpp);
		
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < 100000000 ; i ++) {
			bloomFilter.put(i);
		}
		System.out.println((System.currentTimeMillis() - start) + ":ms");
		
		/*
		 * //怎么测试这个误判率 int t = 0 ; for(int i = 20000000 ; i < 30000000 ; i++) {
		 * if(bloomFilter.mightContain(i)) { //表示存在 t ++; } }
		 * System.out.println("误判的个数:" + t);
		 */
	}
}
