package com.isoftstone.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

public class TestDataInputStreamAndDataOutputStream {
	@Test
	public void test(){
		DataOutputStream dos = null;
		try {
			//将内存中的基本数据保存到文件中
			dos = new DataOutputStream(new FileOutputStream("F:/dest.txt"));
			dos.writeUTF("小鸡小鸡咯咯哒！");
			dos.flush();
			dos.writeInt(1);
			dos.flush();
			dos.writeBoolean(true);
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		DataInputStream dis = null;
		try {
			//将文件中的基本数据读取到内存
			dis = new DataInputStream(new FileInputStream("F:/dest.txt"));
			//这里读取的顺序必须是存入的顺序，否则报错
			System.out.println("title=" + dis.readUTF());
			System.out.println("index=" + dis.readInt());
			System.out.println("isExist=" + dis.readBoolean());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
