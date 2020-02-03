package com.isoftstone.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

/**
 * @author zmjjobs
 * 抽象基类                              节点流 /文件流                         	缓冲流(处理流的一种)              
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
			//实例化File对象
			File srcFile = new File("F:/JavaZongJieBiJi/Java英语缩写名词.txt");
			System.out.println(srcFile.getAbsolutePath());
			//输入流
			fr = new FileReader(srcFile);
			File destFile = new File("F:/output.txt");
			///输出流
			//输出流对应的文件名如果不存在  则会自动创建一个
			//输出流对应的文件名如果存在  则默认按覆盖文件处理;append=true，则会追加内容
			fw = new FileWriter(destFile);
			//fw = new FileWriter(outputFile,true);
			//读取  每次只能读取一个字符
			int data;
			while((data = fr.read()) != -1) {
				fw.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fw != null) {
				try {
					//关闭流
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					//关闭流
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
			//实例化File对象
			File srcFile = new File("F:/JavaZongJieBiJi/Java英语缩写名词.txt");
			//输入流
			fr = new FileReader(srcFile);
			File destFile = new File("F:/output.txt");
			//输出流
			//输出流对应的文件名如果不存在  则会自动创建一个
			//输出流对应的文件名如果存在  则默认按覆盖文件处理;append=true，则会追加内容
			fw = new FileWriter(destFile);
			//fw = new FileWriter(outputFile,true);
			//读取  每次读取N个字符
			char[] cbuf = new char[5];
			int len;
			while((len = fr.read(cbuf)) != -1) {
				//这里new String里面必须要指定截取长度
				//因为cbuf每次属于替换的过程
				fw.write(cbuf,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fw != null) {
				try {
					//关闭流
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					//关闭流
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
