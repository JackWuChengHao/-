package com.xiaowu.utils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public abstract class Utils {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		String a = "0123456789";
		byte[] cc = new EncodeChain.EncodeChainBuilder().EncodeBySHA(a.getBytes()).EncodeByMd5().Base64Encode().getResult().getData_arr();
		String ccc  = new String(cc,"utf-8");
		System.out.println(ccc);
	}
}
