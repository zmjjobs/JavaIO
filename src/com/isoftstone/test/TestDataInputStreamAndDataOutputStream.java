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
			//���ڴ��еĻ������ݱ��浽�ļ���
			dos = new DataOutputStream(new FileOutputStream("F:/dest.txt"));
			dos.writeUTF("С��С�������գ�");
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
			//���ļ��еĻ������ݶ�ȡ���ڴ�
			dis = new DataInputStream(new FileInputStream("F:/dest.txt"));
			//�����ȡ��˳������Ǵ����˳�򣬷��򱨴�
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
