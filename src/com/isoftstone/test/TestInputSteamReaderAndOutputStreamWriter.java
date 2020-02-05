package com.isoftstone.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class TestInputSteamReaderAndOutputStreamWriter {
	@Test
	public void test1(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try {
			fis = new FileInputStream("F:/JavaZongJieBiJi/JavaӢ����д����.txt");
			fos = new FileOutputStream("F:/abc.txt");
			//isr = new InputStreamReader(fis);//ʹ�ù���Ĭ�ϵ��ַ���
			//isr = new InputStreamReader(fis,"UTF-8");
			isr = new InputStreamReader(fis,"GBK");//ʹ��ָ���ĵ��ַ���
			osw = new OutputStreamWriter(fos,"UTF-8");//ָ������ļ����ַ����������൱�ڰ�GBK���ļ������һ��UTF8���ļ�
			char[] cbuf = new char[1024];
			int len;
			while((len = isr.read(cbuf)) != -1) {
				osw.write(cbuf,0,len);
				//��ӡ������̨��������Ƕ�Ӧ���ַ��������ʾ���룬���ǲ�Ӱ������ļ�
				System.out.println(new String(cbuf,0,len));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
