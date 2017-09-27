package anla.study.LeetCode.easy;

/**
 * 关于有21题引发的，对java中传引用的思考与实践
 * 
 * @author anla7856
 *
 */
public class Problem_21_MergeTwoSortedLists_Test3 {
	public static void main(String[] args) {
		Problem_21_MergeTwoSortedLists_Test3 p = new Problem_21_MergeTwoSortedLists_Test3();
		p.quoteTest6();
	}

	/**
	 * output： lh is:ListNode [val=2, next=ListNode [val=1, next=ListNode
	 * [val=1, next=ListNode [val=1, next=ListNode [val=1, next=ListNode [val=1,
	 * next=ListNode [val=1, next=null]]]]]]] l is:ListNode [val=1, next=null]
	 */
	private void quoteTest1() {
		ListNode l = new ListNode(2);
		// l2h指向一开始的l，也就是指向l2的头节点
		ListNode lh = l;
		for (int i = 0; i < 6; i++) {
			l.next = new ListNode(1);
			// 注意此时，l不为null，l的next才为null
			l = l.next;
		}
		System.out.println("lh is:" + lh);
		System.out.println("l is:" + l);
	}

	/**
	 * output: lh is:null l is:ListNode [val=1, next=null]
	 */
	private void quoteTest2() {
		ListNode l = null;
		// l2h指向一开始的l，也就是指向l2的头节点
		ListNode lh = l;
		l = new ListNode(2);
		for (int i = 0; i < 6; i++) {
			l.next = new ListNode(1);
			// 注意此时，l不为null，l的next才为null
			l = l.next;
		}
		System.out.println("lh is:" + lh);
		System.out.println("l is:" + l);
	}

	/**
	 * output: lh is:ListNode [val=2, next=ListNode [val=1, next=ListNode
	 * [val=1, next=ListNode [val=1, next=ListNode [val=1, next=ListNode [val=1,
	 * next=ListNode [val=1, next=null]]]]]]] l is:ListNode [val=1, next=null]
	 */
	private void quoteTest3() {
		ListNode l = new ListNode(2);
		boolean firstInitialize = false;
		ListNode lh = null;
		// l2h指向一开始的l，也就是指向l2的头节点
		if (!firstInitialize) {
			lh = l;
			firstInitialize = true;
		}

		for (int i = 0; i < 6; i++) {
			l.next = new ListNode(1);
			// 注意此时，l不为null，l的next才为null
			l = l.next;
		}
		System.out.println("lh is:" + lh);
		System.out.println("l is:" + l);
	}

	/**
	 * output: lh is:ListNode [val=2, next=null] l is:null
	 */
	private void quoteTest4() {
		ListNode l = null, lh = null;
		boolean firstInitialize = false;
		for (int i = 0; i < 6; i++) {
			// 执行之前，l为null。
			l = new ListNode(2);
			// l2h指向一开始的l，也就是指向l2的头节点，这段代码单线程下会保证只会执行一次嘛
			if (!firstInitialize) {
				lh = l;
				firstInitialize = true;
			}
			// l不为null，但是l.next为null，所以下一次l又为null了。
			l = l.next;
		}
		System.out.println("lh is:" + lh);
		System.out.println("l is:" + l);
	}

	/**
	 * output: lh is:ListNode [val=2, next=null] l is:ListNode [val=1,
	 * next=null]
	 */
	private void quoteTest5() {
		ListNode l = new ListNode(1), lh = new ListNode(2);
		// 传递l和lh的引用，事实证明传的是地址的复制，l和l2完全没有改变
		quoteHelp1(lh, l);
		quoteHelp3(l);
		System.out.println("lh is:" + lh);
		System.out.println("l is:" + l);
	}

	/**
	 * 仅用于给quoteTest5来使用的工具方法类 里面的业务代码和 quoteTest4 一模一样
	 * 
	 * @param lh
	 * @param l
	 */
	private void quoteHelp1(ListNode lh, ListNode l) {
		boolean firstInitialize = false;
		for (int i = 0; i < 6; i++) {
			// 执行之前，l为null。
			l = new ListNode(2);
			// l2h指向一开始的l，也就是指向l2的头节点，这段代码单线程下会保证只会执行一次嘛
			if (!firstInitialize) {
				lh = l;
				firstInitialize = true;
			}
			// l不为null，但是l.next为null，所以下一次l又为null了。
			l = l.next;
		}
	}

	/**
	 * output: l is:ListNode [val=2, next=ListNode [val=1, next=ListNode [val=1,
	 * next=ListNode [val=1, next=ListNode [val=1, next=ListNode [val=1,
	 * next=ListNode [val=1, next=null]]]]]]]
	 */
	private void quoteTest6() {
		ListNode l = new ListNode(3);
		l = quoteHelp2();
		System.out.println("l is:" + l);
	}

	/**
	 * quoteTest6的工具方法
	 * 
	 * @return
	 */
	private ListNode quoteHelp2() {
		
		ListNode l = new ListNode(2);
		// l2h指向一开始的l，也就是指向l2的头节点
		ListNode lh = l;
		for (int i = 0; i < 6; i++) {
			l.next = new ListNode(1);
			// 注意此时，l不为null，l的next才为null
			l = l.next;
		}
		return lh;
	}
	
	private void quoteHelp3(ListNode l){
		l.val = 5;
	}
}
