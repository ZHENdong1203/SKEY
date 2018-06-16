package skey;
import java.io.*; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;  
public class MD5 { // ȫ������ 
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" }; 
	public MD5() { 
}// ������ʽΪ���ָ��ַ��� 
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
	// ������ʽֻΪ���� 
	private static String byteToNum(byte bByte) { 
		int iRet = bByte; 
		System.out.println("iRet1=" + iRet); 
		if (iRet < 0) { 
			iRet += 256; 
		}
		return String.valueOf(iRet); 
		} 
	// ת���ֽ�����Ϊ16�����ִ� 
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
			// md.digest() �ú�������ֵΪ��Ź�ϣֵ�����byte���� 
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
			System.out.println("������֤��"+(99-i)+"    "+string); 
			} 
		string=GetMD5Code(str); 
		while(bl){ 
			System.out.println("��������֤��"); 
			InputStreamReader isr=new InputStreamReader(System.in); 
			BufferedReader br=new BufferedReader(isr); 
			String str1=br.readLine(); 
			if(GetMD5Code(str1).equals(string)){ 
				System.out.println("��֤��ȷ"); 
				string=str1; 
				} 
			else 
				System.out.println("��֤����"); 
			} 
		} 
	public static void main(String[] args) throws Exception { 
		MD5 getMD5 = new MD5(); 
		InputStreamReader isr=new InputStreamReader(System.in); 
		BufferedReader br=new BufferedReader(isr); 
		System.out.println("������֤��Ϣ"); 
		String str=br.readLine(); 
		getMD5.skey(str); 
		} 
	}