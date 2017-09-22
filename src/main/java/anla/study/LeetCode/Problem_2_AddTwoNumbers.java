package anla.study.LeetCode;

public class Problem_2_AddTwoNumbers {
	public static void main(String[] args) {
		Problem_2_AddTwoNumbers p = new Problem_2_AddTwoNumbers();
		ListNode l1 = new ListNode(1);
		ListNode l1h = l1;

		ListNode l2 = new ListNode(9);
		ListNode l2h = l2;
		l2.next = new ListNode(9);

		ListNode l = p.addTwoNumbers(l1h, l2h);

		while (l != null) {
			System.out.println(l.val + " ");
			l = l.next;
		}

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = null, queue = null;
		// 如果一开始在这个位置进行：queue = result，这样最终queue还是为null，
		if (l1 == null && l2 == null) {
			return new ListNode(0);
		}
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}
		// 进位
		int add = 0;
		while (l1 != null && l2 != null) {

			if (result == null) {
				result = new ListNode((l1.val + l2.val + add) % 10);
				// 在这里进行引用赋值，就可以
				queue = result;
			} else {
				result.next = new ListNode((l1.val + l2.val + add) % 10);
				result = result.next;
			}

			if ((l1.val + l2.val + add) > 9) {
				add = 1;
			} else {
				add = 0;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			result.next = new ListNode((l1.val + add) % 10);
			result = result.next;
			if ((l1.val + add) > 9) {
				add = 1;
			} else {
				add = 0;
			}
			l1 = l1.next;
		}

		while (l2 != null) {
			result.next = new ListNode((l2.val + add) % 10);
			result = result.next;
			if ((l2.val + add) > 9) {
				add = 1;
			} else {
				add = 0;
			}
			l2 = l2.next;
		}

		if (l1 == null && l2 == null && add == 1) {
			result.next = new ListNode((add) % 10);
		}

		return queue;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}