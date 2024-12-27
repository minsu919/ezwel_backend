package secure;

import java.util.regex.Pattern;

public class PassValidator {
	static String password_pattern = 
			"^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=])[A-z0-9!@#$%^&*()-+=]{10,12}$";
	static Pattern pattern = Pattern.compile(password_pattern);
	
	public static boolean isValid(String password) {
		if (password == null) return false;
		return pattern.matcher(password).matches();
		
	}

	public static void main(String[] args) {
		// 최소 1개 영대, 1개영소 1개숫자 1특수문자 10글자 12글자 사이
		String[] pwlist = {"Password123!", "passwird123!", "Password1233", "Password*"};
		for (String pw : pwlist) {
			if (isValid(pw)) {
				System.out.println(pw + " : 사용가능한 암호입니다");
			} else {
				System.out.println(pw + " : 사용 불가능한 암호입니다");
			}
		}
	}
	

}
