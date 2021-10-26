# 剑指Offer刷题记录



### 004-只出现一次的数字
给定一个**非空**整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

**说明**：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

```
输入: [2,2,1]
输出: 1
```

示例 1:

```
输入: [4,1,2,1,2]
输出: 4
```

#### 解法一：位运算
1. 0 ^ num = num，总结来说就是用0异或一个数可以得到其值
2. b = b ^ a ^ a = a ^ b ^ a；异或运算服从交换律
3. b = 0 ^ a ^ b ^ c ^ a ^ c；一个数偶数次异或某一个数后值不变

```java
class Solution {
	public int singleNumber(int[] nums) {
		int ans = 0;	
		for (int i = 0; i < nums.length; i++) { 
			ans ^= nums[i];
		}

		return ans;
	}
}
```





### [009-用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

#### 题目描述

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 `appendTail` 和 `deleteHead`，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，`deleteHead` 操作返回 `-1` )

#### 输入实例

##### 示例1

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

##### 示例2

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

#### 标签

栈，队列

#### 题目代码

##### 方法一

```java
class CQueue {
	Deque<Integer> stack1;
	Deque<Integer> stack2;

	public CQueue() {
		stack1 = new LinkedList<Integer>();
		stack2 = new LinkedList<Integer>();
	}

	public void appendTail(int value) {
		stack1.push(value);
	}

	public int deleteHead() {
		if (stack2.isEmpty()) {
			while (stack1.isEmpty() == false) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			return -1;
		}

		return stack2.pop();
	}
}

/**
 * Your CQueue object will be instantiated and called as such: 
 * CQueue obj = new CQueue(); 
 * obj.appendTail(value); 
 * int param_2 = obj.deleteHead();
 */
```



### [030-包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

#### 题目描述

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 `min()`、`push()` 及 `pop()` 的时间复杂度都是 O(1)。

#### 示例

```
输入：
["MinStack","push","push","push","min","pop","top","min"]
[[],[-2],[0],[-3],[],[],[],[]]
输出：
[null,null,null,null,-3,null,0,-2]
```

#### 标签

栈

#### 题解

##### 方法一

使用双栈，一个栈存储数据，另一个栈存储历次入栈时的最小值，且保证从栈底到栈顶严格非增(相同的最小值一并存储)。

* 当元素入栈时，数据栈正常入栈，另一个栈判大小再决定入栈；
* 当元素出栈时，数据栈正常出栈，如果最小值和元素栈顶相等也一并出栈。

```java
class MinStack {
    Stack<Integer> data;
    Stack<Integer> minData;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }
    
    public void push(int x) {
        data.add(x);
        if(minData.empty() || minData.peek() >= x) {
            minData.add(x);
        }
    }
    
    public void pop() {
        if (data.pop().equals(minData.peek())) {
            minData.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return minData.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```


### [052-两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)
#### 题目描述
输入两个链表，找出它们的第一个公共节点。

如下面的两个链表：
![链表的公共节点](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

在节点 c1 开始相交。

#### 示例
##### 示例1
![示例1](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)

```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
```

#### 标签
哈希表，链表，双指针

#### 解法
##### 解法一：哈希表+遍历
```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode tmp = headA;
        while (tmp != null) {
            set.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if (set.contains(tmp)) {
                return tmp;
            }
            tmp = temp.next;
        }
        return null;
    }
}
```

##### 解法二：双指针

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tmp1 = headA, tmp2 = headB;
        while (tmp1 != tmp2) {
            tmp1 = tmp1 == null ? headB : tmp1.next;
            tmp2 = tmp2 == null ? headA : tmp2.next;
        }

        return tmp2;
    }
}
```
