public class BinarySearchProblem {
	
	public static void main(String[] args) {
		int[] numbers = {12, 25, 31, 48, 54, 66, 78, 86, 91, 105};
		
		int target = 56;
		int left = 0;
		int right = numbers.length; // 10
		int mid = (left + right) / 2 ; // 5
		int temp = numbers[mid]; // init : numbers[5] -> 66
		Boolean find = false;
		
		while (left <= right) {
			if (target ==  temp) {
				find = true;
				break;
			} else if (target > temp) {
				left = mid + 1;
			} else { right = mid - 1; }
			
			mid = (left + right) / 2;
			temp = numbers[mid];
		}
		
		if (find==true) {
			mid++;
			System.out.println("찾고자하는 수는 " +mid+ "번째에 있습니다");
		} else {
			System.out.println("찾고자하는 수가 없습니다");
		}
	}
}
