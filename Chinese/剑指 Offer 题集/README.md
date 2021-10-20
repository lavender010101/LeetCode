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



