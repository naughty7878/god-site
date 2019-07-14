package com.god.common.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * this is a tool,  md5 class realized RSA Data Security, Inc.commit to IETF
 * of RFC1321 MD5 message-digest algorithm
 * @author Administrator
 *
 */
public class MD5Utils {
	
	public MD5Utils(){
		
	}
	
	/**
	 * MD5 Encryption method
	 * method:getMD5ofStr
	 * @param srcstr 
	 * @return a string after Encryption with MD5
	 */
    public static String getMD5ofStr(String srcstr){
    	MessageDigest messageDigest;
    	String digestedPwdString="";
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(srcstr.getBytes());
        	byte[] bin = messageDigest.digest();
        	digestedPwdString=byte2hex(bin);
        	digestedPwdString=digestedPwdString.toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			digestedPwdString="";
		}
		return digestedPwdString;
    }
    
    /**
     * Will be transferred to the array of characters labeled as a hexadecimal string
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b){
        String hs="";
        String stmp="";
        for (int n=0; n<b.length; n++){
            stmp=(java.lang.Integer.toHexString(b[n] & 0xFF));   
            if (stmp.length()==1) hs=hs+"0"+stmp;
                else hs=hs+stmp;                    
        }
        return hs;
    } 

    /**
     * test code
     * @param args
     */
    public static void main(String args[]) {
        MD5Utils m = new MD5Utils(); 
		String str2 = MD5Utils.getMD5ofStr("123456");
		System.out.println(str2);
    }

}

