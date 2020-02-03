package com.isoftstone.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

/**
 * @author zmjjobs
 * �������                              �ڵ��� /�ļ���                         	������(��������һ��)              
 * InputStream    FileInputStream    BufferedFileInputStream
 * OutputSream    FileOutputSteam    BufferedFileOutputSream
 * Reader         FileReader         BufferedFileReader
 * Writer         FileWriter         BufferedFileWriter
 */
public class TestFileInputStreamAndFileOutputSream {
	@Test
	public void testFile1(){
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			File srcFile = new File("F:/MySelfPic/1491749608618.jpg");
			fi = new FileInputStream(srcFile);
			File destFile = new File("F:/dest.jpg");
			fo = new FileOutputStream(destFile);
			int data;
			while((data = fi.read()) != -1) {
				fo.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fo != null) {
				try {
					//�ر���
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fi != null) {
				try {
					//�ر���
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void testFile2(){
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			File srcFile = new File("F:/MySelfPic/1491749608618.jpg");
			fi = new FileInputStream(srcFile);
			File destFile = new File("F:/dest.jpg");
			fo = new FileOutputStream(destFile);
			byte[] cbuf = new byte[1024];
			int len;
			while((len = fi.read(cbuf)) != -1) {
				fo.write(cbuf,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fo != null) {
				try {
					//�ر���
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fi != null) {
				try {
					//�ر���
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
