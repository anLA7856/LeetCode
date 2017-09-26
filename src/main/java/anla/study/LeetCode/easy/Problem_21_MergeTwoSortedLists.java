package anla.study.LeetCode.easy;

/**
 * 
 * @author anla7856
 *
 */
public class Problem_21_MergeTwoSortedLists {
	public static void main(String[] args) {
		Problem_21_MergeTwoSortedLists p = new Problem_21_MergeTwoSortedLists();
		ListNode l2 = new ListNode(1);
		ListNode l2h = l2;
		l2.next = new ListNode(2);
		ListNode l1 = new ListNode(5);
		ListNode l1h = l1;
		l1.next = new ListNode(7);
		System.out.println(p.mergeTwoLists(l1h, l2h));
	}

	/**
	 * 降序
	 * 
	 * 事实上，题目要求升序
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null, finalList = null;
		boolean isInitialized = false;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				if (result == null) {
					result = new ListNode(l1.val);
					finalList = result;
				} else {
					result.next = new ListNode(l1.val);
					result = result.next;
				}

				l1 = l1.next;
			} else {
				if (result == null) {
					result = new ListNode(l2.val);
					finalList = result;
				} else {
					result.next = new ListNode(l2.val);
					result = result.next;
				}
				l2 = l2.next;
			}

		}

		while (l1 != null) {
			if (result == null) {
				result = new ListNode(l1.val);
				finalList = result;
			} else {
				result.next = new ListNode(l1.val);
				result = result.next;
			}
			l1 = l1.next;
		}
		while (l2 != null) {
			if (result == null) {
				result = new ListNode(l2.val);
				finalList = result;
			} else {
				result.next = new ListNode(l2.val);
				result = result.next;
			}
			l2 = l2.next;
		}
		return finalList;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}