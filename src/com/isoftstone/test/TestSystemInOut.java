package com.isoftstone.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestSystemInOut {
	@Test
	public void test(){
		//System.in ��׼����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data;
		try {
			while(true) {
				System.out.println("�������ַ�����");
				try {
					//��ȡ��������
					data = br.readLine();
					if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
						System.out.println("�������.....");
						break;
					}
					//���������̨
					System.out.println(data.toUpperCase());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
