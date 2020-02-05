package com.isoftstone.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

/**
 * @author zmjjobs
 * 抽象基类                              节点流 /文件流                         	缓冲流(处理流的一种)              
 * InputStream    FileInputStream    BufferedInputStream
 * OutputSream    FileOutputSteam    BufferedOutputSream
 * Reader         FileReader         BufferedReader
 * Writer         FileWriter         BufferedWriter
 */
public class TestBufferedReaderAndBufferedWriter {
	@Test
	public void testFile1(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(new File("F:/JavaZongJieBiJi/Java英语缩写名词.txt")));
			bw = new BufferedWriter(new FileWriter(new File("F:/abc.txt")));
			//每次最多读取1024个字符
			char[] cbuf = new char[1024];
			int len;
			while((len = br.read(cbuf)) != -1) {
				bw.write(cbuf,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 	}
	
	@Test
	public void testFile2(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(new File("F:/JavaZongJieBiJi/Java英语缩写名词.txt")));
			bw = new BufferedWriter(new FileWriter(new File("F:/abc.txt")));
			//每次读取一行
			String data;
			while((data = br.readLine()) != null) {
				bw.write(data);
				//每次记着要换行
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
