package com.isoftstone.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
					//关闭流
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fi != null) {
				try {
					//关闭流
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
					//关闭流
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fi != null) {
				try {
					//关闭流
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 对图片进行加密解密      图片解密跟图片加密代码是一样的，怎样加密的，怎么解密
	 * 也适应于.doc,.pdf等
	 * 其实对文本文件加密解密也可以使用，只要不读取，纯复制没有问题
	 */
	@Test
	public void testImageJiaMi(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("F:/MySelfPic/1491749608618.jpg");
			fos = new FileOutputStream("F:/JiaMiTuPian.jpg");
			byte[] cbuf = new byte[1024];
			int len;
			while((len = fis.read(cbuf)) != -1) {
				for (int i = 0; i < len; i++) {
					//加密或解密
					cbuf[i] = (byte) (cbuf[i] ^ 123);
				}
				fos.write(cbuf,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fos != null) {
				try {
					fos.close();
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
