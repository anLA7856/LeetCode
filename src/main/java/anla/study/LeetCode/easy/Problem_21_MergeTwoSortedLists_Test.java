package anla.study.LeetCode.easy;

public class Problem_21_MergeTwoSortedLists_Test {
	public static void main(String[] args) {
		Problem_21_MergeTwoSortedLists_Test p = new Problem_21_MergeTwoSortedLists_Test();
		ListNode l2 = new ListNode(2);
		ListNode l2h = l2;
		l2.next = new ListNode(1);
		ListNode l1 = new ListNode(7);
		ListNode l1h = l1;
		l1.next = new ListNode(5);
		System.out.println(p.mergeTwoLists(l1h, l2h));
	}

	/**
	 * 降序
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null, finalList = null;
		boolean isInitialized = false;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				result = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				result = new ListNode(l2.val);
				l2 = l2.next;
			}
			if (!isInitialized) {
				finalList = result;
				isInitialized = true;
			}

			result = result.next;
		}

		if (l1 != null) {
			result = new ListNode(l1.val);
			l1 = l1.next;
			if (!isInitialized) {
				finalList = result;
				isInitialized = true;
			}
			result = result.next;
		}
		if (l2 != null) {
			result = new ListNode(l2.val);
			l2 = l2.next;
			if (!isInitialized) {
				finalList = result;
				isInitialized = true;
			}
			result = result.next;
		}
		return finalList;
	}
}
