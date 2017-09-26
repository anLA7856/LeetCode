package anla.study.LeetCode.easy;

/**
 * 无法得到预期值 如果把相似的业务代码封装起来，在这种引用情况下，是不能够正常运行的 只会返回null
 * 
 * @author anla7856
 *
 */
public class Problem_21_MergeTwoSortedLists_Test2 {
	public static void main(String[] args) {
		Problem_21_MergeTwoSortedLists_Test2 p = new Problem_21_MergeTwoSortedLists_Test2();
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
				spliceList(result, l1, finalList);
				l1 = l1.next;
			} else {
				spliceList(result, l2, finalList);
				l2 = l2.next;
			}

		}

		while (l1 != null) {
			spliceList(result, l1, finalList);
			l1 = l1.next;
		}
		while (l2 != null) {
			spliceList(result, l2, finalList);
			l2 = l2.next;
		}
		return finalList;
	}

	private void spliceList(ListNode result, ListNode ln, ListNode finalList) {
		if (result == null) {
			result = new ListNode(ln.val);
			finalList = result;
		} else {
			result.next = new ListNode(ln.val);
			result = result.next;
		}
	}
}
