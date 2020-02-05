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
			fis = new FileInputStream("F:/JavaZongJieBiJi/Java英语缩写名词.txt");
			fos = new FileOutputStream("F:/abc.txt");
			//isr = new InputStreamReader(fis);//使用工程默认的字符集
			//isr = new InputStreamReader(fis,"UTF-8");
			isr = new InputStreamReader(fis,"GBK");//使用指定的的字符集
			osw = new OutputStreamWriter(fos,"UTF-8");//指定输出文件的字符集，这里相当于把GBK的文件输出了一份UTF8的文件
			char[] cbuf = new char[1024];
			int len;
			while((len = isr.read(cbuf)) != -1) {
				osw.write(cbuf,0,len);
				//打印到控制台，如果不是对应的字符集则会显示乱码，但是不影响输出文件
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
