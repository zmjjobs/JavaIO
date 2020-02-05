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
 * �������                              �ڵ��� /�ļ���                         	������(��������һ��)              
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
			br = new BufferedReader(new FileReader(new File("F:/JavaZongJieBiJi/JavaӢ����д����.txt")));
			bw = new BufferedWriter(new FileWriter(new File("F:/abc.txt")));
			//ÿ������ȡ1024���ַ�
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
			br = new BufferedReader(new FileReader(new File("F:/JavaZongJieBiJi/JavaӢ����д����.txt")));
			bw = new BufferedWriter(new FileWriter(new File("F:/abc.txt")));
			//ÿ�ζ�ȡһ��
			String data;
			while((data = br.readLine()) != null) {
				bw.write(data);
				//ÿ�μ���Ҫ����
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
