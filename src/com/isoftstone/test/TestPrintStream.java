package com.isoftstone.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.Test;

public class TestPrintStream {
	@Test
	public void test(){
		PrintStream ps = null;
		try {
			//������ӡ�����������Ϊ�Զ�ˢ��
			ps = new PrintStream(new FileOutputStream("F:/aaa.txt"),true);
			if (ps != null) {
				//�ѿ���̨Ҫ���������д���ļ���
				System.setOut(ps);
			}
			for (int i = 0; i < 255; i++) {
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				ps.close();
		}
	}
}
