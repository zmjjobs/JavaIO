package com.isoftstone.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
public class TestFileReaderAndFileWriter {
	@Test
	public void testFile1(){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//ʵ����File����
			File srcFile = new File("F:/JavaZongJieBiJi/JavaӢ����д����.txt");
			System.out.println(srcFile.getAbsolutePath());
			//������
			fr = new FileReader(srcFile);
			File destFile = new File("F:/output.txt");
			///�����
			//�������Ӧ���ļ������������  ����Զ�����һ��
			//�������Ӧ���ļ����������  ��Ĭ�ϰ������ļ�����;append=true�����׷������
			fw = new FileWriter(destFile);
			//fw = new FileWriter(outputFile,true);
			//��ȡ  ÿ��ֻ�ܶ�ȡһ���ַ�
			int data;
			while((data = fr.read()) != -1) {
				fw.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fw != null) {
				try {
					//�ر���
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					//�ر���
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testFile2(){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//ʵ����File����
			File srcFile = new File("F:/JavaZongJieBiJi/JavaӢ����д����.txt");
			//������
			fr = new FileReader(srcFile);
			File destFile = new File("F:/output.txt");
			//�����
			//�������Ӧ���ļ������������  ����Զ�����һ��
			//�������Ӧ���ļ����������  ��Ĭ�ϰ������ļ�����;append=true�����׷������
			fw = new FileWriter(destFile);
			//fw = new FileWriter(outputFile,true);
			//��ȡ  ÿ�ζ�ȡN���ַ�
			char[] cbuf = new char[5];
			int len;
			while((len = fr.read(cbuf)) != -1) {
				//����new String�������Ҫָ����ȡ����
				//��Ϊcbufÿ�������滻�Ĺ���
				fw.write(cbuf,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fw != null) {
				try {
					//�ر���
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					//�ر���
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
