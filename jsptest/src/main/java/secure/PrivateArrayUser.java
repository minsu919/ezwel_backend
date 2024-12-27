package secure;

import java.util.Arrays;

public class PrivateArrayUser {
	private String colors[] = {"빨강","노랑","주황","초록"};
	
	
	
	// 안전하지않음
	public String[] getColors() {
		return colors;
	}
	
	public String[] getColors2() {
		String[] localColors = null;
		if (colors != null) {
			localColors = new String[colors.length]; // 저장값 없고 colors의 길이만큼 배열 생성
			for (int i=0; i<colors.length; i++) {
				localColors[i] = colors[i];
				// localColors 는 colors 내용 복사. colors 참
			}
		}
		return localColors;
	}
	public static void main(String[] args) {
		PrivateArrayUser user = new PrivateArrayUser();
		/*
		 * String[] mainColors = user.getColors(); mainColors[0] = "검정"; // public 메소드
		 * 결과 리턴받은 배열 내용 변경
		 * 
		 * System.out.println("mainColors=>" + Arrays.toString(mainColors));
		 * System.out.println("colors=>" + Arrays.toString(user.colors));
		 */
		
		String[] mainColors = user.getColors2();
		mainColors[0] = "검정"; // public 메소드 결과 리턴받은 배열 내용 변경
		
		System.out.println("mainColors=>" + Arrays.toString(mainColors));
		System.out.println("colors=>" + Arrays.toString(user.colors));
	}

}
