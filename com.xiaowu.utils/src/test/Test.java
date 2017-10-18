package test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.xiaowu.utils.EncodeChain;

public class Test {
		public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
			String aa = "wuchenghao";
			byte[] str_arr = new EncodeChain.EncodeChainBuilder().Base64Encode(aa.getBytes()).EncodeByMd5().EncodeBySHA().Base64Encode().getResult().getData_arr();
			System.out.println(new String(str_arr,"UTF-8"));
		}
}
