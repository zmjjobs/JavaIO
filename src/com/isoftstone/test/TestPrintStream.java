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
			//创建打印输出流，设置为自动刷新
			ps = new PrintStream(new FileOutputStream("F:/aaa.txt"),true);
			if (ps != null) {
				//把控制台要输出的内容写入文件中
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
