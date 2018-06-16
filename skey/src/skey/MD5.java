package skey;
import java.io.*; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;  
public class MD5 { // 全局数组 
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" }; 
	public MD5() { 
}// 返回形式为数字跟字符串 
	private static String byteToArrayString(byte bByte) { 
		int iRet = bByte; 
// System.out.println("iRet="+iRet); 
		if (iRet < 0) { 
			iRet += 256; 
			} 
		int iD1 = iRet / 16; 
		int iD2 = iRet % 16; 
		return strDigits[iD1] + strDigits[iD2]; 
		} 
	// 返回形式只为数字 
	private static String byteToNum(byte bByte) { 
		int iRet = bByte; 
		System.out.println("iRet1=" + iRet); 
		if (iRet < 0) { 
			iRet += 256; 
		}
		return String.valueOf(iRet); 
		} 
	// 转换字节数组为16进制字串 
	private static String byteToString(byte[] bByte) { 
		StringBuffer sBuffer = new StringBuffer(); 
		for (int i = 0; i < bByte.length; i++) { 
			sBuffer.append(byteToArrayString(bByte[i])); 
			} 
		return sBuffer.toString(); 
		} 
	public static String GetMD5Code(String strObj) { 
		String resultString = null; 
		try { 
			resultString = new String(strObj); 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			// md.digest() 该函数返回值为存放哈希值结果的byte数组 
			resultString = byteToString(md.digest(strObj.getBytes())); 
			} catch (NoSuchAlgorithmException ex) { 
				ex.printStackTrace(); 
				} 
		return resultString; 
		} 
	public void skey(String str) throws IOException{ 
		Boolean bl=true; 
		String string=new String(); 
		for(int i=0;i<99;i++){ 
			string=GetMD5Code(str); 
			str=string; 
			System.out.println("生成验证码"+(99-i)+"    "+string); 
			} 
		string=GetMD5Code(str); 
		while(bl){ 
			System.out.println("请输入验证码"); 
			InputStreamReader isr=new InputStreamReader(System.in); 
			BufferedReader br=new BufferedReader(isr); 
			String str1=br.readLine(); 
			if(GetMD5Code(str1).equals(string)){ 
				System.out.println("验证正确"); 
				string=str1; 
				} 
			else 
				System.out.println("验证错误"); 
			} 
		} 
	public static void main(String[] args) throws Exception { 
		MD5 getMD5 = new MD5(); 
		InputStreamReader isr=new InputStreamReader(System.in); 
		BufferedReader br=new BufferedReader(isr); 
		System.out.println("输入验证信息"); 
		String str=br.readLine(); 
		getMD5.skey(str); 
		} 
	}