package com.xiaowu.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * @author wiaowu
 *用于加密的工具类，可以采用链式操作对一个byte[]进行SHA，MD5，Base64的叠加编码
 */
public class  EncodeChain extends Utils{
	private byte[] data_arr;

	public byte[] getData_arr() {
		return data_arr;
	}

	public void setData_arr(byte[] data_arr) {
		this.data_arr = data_arr;
	}

	public EncodeChain() {
		
	}

	public static class EncodeChainBuilder{
		//		
		private EncodeChain ec;

		public EncodeChainBuilder(){
			ec = new EncodeChain();
		}

		/**
		 * 二进制转十进制十六进制
		 * @param bytes
		 * @return
		 */
		private String bytesToHex(byte[] bytes) {  
			StringBuffer hexStr = new StringBuffer();  
			int num;  
			int length = bytes.length;
			for (int i = 0; i < length; i++) {  
				num = bytes[i];  
				if(num < 0) {  
					num += 256;  
				}  
				if(num < 16){  
					hexStr.append("0");  
				}  
				hexStr.append(Integer.toHexString(num));  
			}  
			return hexStr.toString().toUpperCase();  
		}  

		public EncodeChainBuilder Base64Encode(final byte[] data) {
			if(data == null)
				throw new NullPointerException("需要加密的字节数据不能为空");
			ec.setData_arr(Base64.encodeBase64(data));
			return this;
		}

		public EncodeChainBuilder Base64Encode() {
			if(ec.getData_arr() == null)
				throw new NullPointerException("需要加密的字节数据不能为空");
			ec.setData_arr(Base64.encodeBase64(ec.getData_arr()));
			return this;
		}

		public  EncodeChainBuilder  EncodeByMd5(final byte[] data) throws NoSuchAlgorithmException, UnsupportedEncodingException{
			if(data == null)
				throw new NullPointerException("需要加密的字节数据不能为空");
			MessageDigest md5=MessageDigest.getInstance("MD5");
			ec.setData_arr(bytesToHex(md5.digest(data)).getBytes());
			return this;
		}

		public  EncodeChainBuilder  EncodeByMd5() throws NoSuchAlgorithmException, UnsupportedEncodingException{
			if(ec.getData_arr() == null)
				throw new NullPointerException("需要加密的字节数据不能为空");
			MessageDigest md5=MessageDigest.getInstance("MD5");
			ec.setData_arr(bytesToHex(md5.digest(ec.getData_arr())).getBytes());
			return this;
		}

		public  EncodeChainBuilder  EncodeBySHA() throws NoSuchAlgorithmException, UnsupportedEncodingException{
			if(ec.getData_arr() == null)
				throw new NullPointerException("需要加密的字节数据不能为空");
			MessageDigest sha=MessageDigest.getInstance("SHA");
			ec.setData_arr(bytesToHex(sha.digest(ec.getData_arr())).getBytes());
			return this;
		}	

		public  EncodeChainBuilder  EncodeBySHA(final byte[] data) throws NoSuchAlgorithmException, UnsupportedEncodingException{
			if(data == null)
				throw new NullPointerException("需要加密的字节数据不能为空");
			MessageDigest sha=MessageDigest.getInstance("SHA");
			ec.setData_arr(bytesToHex(sha.digest(data)).getBytes());
			return this;
		}

		public EncodeChain getResult() {
			return ec;
		}
	}
}
