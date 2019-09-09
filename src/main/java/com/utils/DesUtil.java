package com.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DesUtil {
	public static final String PWD = "VlandServer";
	/**
	* 加密
	* @param text String
	* @param password String
	* @return String
	*/
	public static String encrypt(String text, String password) { 
		try{
			byte[] datasource = text.getBytes();
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			//创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			//Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			//用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			//现在，获取数据并加密
			//正式执行加密操作
			byte[] b = cipher.doFinal(datasource);
			String res = Base64Util.getBase64(b).replaceAll("\r|\n", "");;
			return res;
		}catch(Throwable e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	* 解密
	* @param text String
	* @param password String
	* @return String
	* @throws Exception
	*/
	public static String decrypt(String text, String password) {
		try{
			byte[] src = Base64Util.getByteFromBase64(text);
			// DES算法要求有一个可信任的随机数源
			SecureRandom random = new SecureRandom();
			// 创建一个DESKeySpec对象
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			// 将DESKeySpec对象转换成SecretKey对象
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成解密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, securekey, random);
			// 真正开始解密操作
			byte[] b = cipher.doFinal(src);
			return new String(b);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}
