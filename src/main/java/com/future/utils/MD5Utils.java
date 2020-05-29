package com.future.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wjn
 * MD5加密工具类
 */
public class MD5Utils {

	public static String getPassword(String pwd){
		//加密动作，获取加密的对象
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			//对数据进行加密,加密的动作已经完成
			byte[] bs = digest.digest(pwd.getBytes());
			
			//对加密后的结果，进行优化，将加密后的结果，先转换成正数，然后，转换成16进制格式
			String password = "";
			for (byte b : bs) {
				//转换成正数
				//b类型byte   进行 & 255 int类型数据，自动类型提升
				//b：1111 1001
				//b转换成int类型之后：0000 0000 0000 0000 0000 0000 1111 1001，最高位变成0之后转换成正数
				int temp = b & 255;
				//转换成16进制格式
				String hexString = Integer.toHexString(temp);
				if(temp >=0 && temp < 16){
					password = password +"0"+ hexString;
				}else{
					password = password + hexString;
				}
			}
			
			return password;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		} 
	}
}
