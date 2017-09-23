package anla.study.LeetCode.easy;

/**
 * 短路与是 &&，逻辑与是&
 * @author anla7856
 *
 */
public class Problem_13_Roman2Integer {
	public static void main(String[] args) {
		Problem_13_Roman2Integer p = new Problem_13_Roman2Integer();
		System.out.println(p.romanToInt("MCMXCVI"));
	}

	public int romanToInt(String s) {
		char[] sArray = s.toCharArray();
		int result = 0;
		int sub = 0;
		for (int i = 0; i < sArray.length; i++) {
			switch (sArray[i]) {
			case 'M':
				result += 1000;
				break;
			case 'D':
				if (i < sArray.length - 1 && (sArray[i + 1] == 'M')) {
					sub += 500;
				} else {
					result += 500;
				}
				break;
			case 'C':
				if (i < sArray.length - 1
						&& (sArray[i + 1] == 'M' || sArray[i + 1] == 'D')) {
					sub += 100;
				} else {
					result += 100;
				}
				break;
			case 'L':
				if (i < sArray.length - 1
						&& (sArray[i + 1] == 'M' || sArray[i + 1] == 'D' || sArray[i + 1] == 'C')) {
					sub += 50;
				} else {
					result += 50;
				}
				break;
			case 'X':
				if (i < sArray.length - 1
						&& (sArray[i + 1] == 'M' || sArray[i + 1] == 'D'
								|| sArray[i + 1] == 'C' || sArray[i + 1] == 'L')) {
					sub += 10;
				} else {
					result += 10;
				}
				break;
			case 'V':
				if (i < sArray.length - 1
						&& (sArray[i + 1] == 'M' || sArray[i + 1] == 'D'
								|| sArray[i + 1] == 'C' || sArray[i + 1] == 'L' || sArray[i + 1] == 'X')) {
					sub += 5;
				} else {
					result += 5;
				}
				break;
			case 'I':
				if (i < sArray.length - 1
						&& (sArray[i + 1] == 'M' || sArray[i + 1] == 'D'
								|| sArray[i + 1] == 'C' || sArray[i + 1] == 'L'
								|| sArray[i + 1] == 'X' || sArray[i + 1] == 'V')) {
					sub += 1;
				} else {
					result += 1;
				}

				break;
			default:
				break;
			}

		}

		return result - sub;
	}
}
