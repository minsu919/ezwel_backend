package secure;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCryptor {
	// 암호화 - 복호화 (양방향알고리즘 : 키 (32글자)
	//final private String secretKey = System.getenv("eclipsekey"); //"oingisprettyintheworld1234567890";
	final private String secretKey = System.getenv("oskey"); //"oingisprettyintheworld1234567890"; // 이후 이클립스 재시작
	// 암호화 + 문자열 데이터 (16글자)
	final private String iv = UUID.randomUUID().toString().substring(0,16);
	
	public String encrypt(String plaintext, String secretKey, String iv) throws Exception {
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,ivParameterSpec);
		byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	
	public String decrypt(String encryptedText, String secretKey, String iv) throws Exception {
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,ivParameterSpec);
		
		byte[] encryptedByte = Base64.getDecoder().decode(encryptedText);
		byte[] decryptedBytes = cipher.doFinal(encryptedByte);
		return new String(decryptedBytes);
	}
	
	public static void main(String[] args) {
		try {
		String plaintext = "Password1234%^&*";
		AESCryptor aesCryptor = new AESCryptor();
		String encryptedText = aesCryptor.encrypt(plaintext, aesCryptor.secretKey, aesCryptor.iv);
		String decryptedText = aesCryptor.decrypt(encryptedText, aesCryptor.secretKey, aesCryptor.iv);
		
		
		System.out.println("원본문자 : "+plaintext);
		System.out.println("암호화문자 : "+encryptedText);
		System.out.println("복호화문자 : "+decryptedText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//원본문자 : Password1234%^&*
//암호화문자 : 2/7BkzjGKaHo4WjJCtIskoTnrZ53IIX5B5aZ0mGPQgs=
//원본문자 : Password1234%^&*
//암호화문자 : IOrruWpE8j61sHDOqWktXPoBg4i8z1C7BipJJtKRIT8=

