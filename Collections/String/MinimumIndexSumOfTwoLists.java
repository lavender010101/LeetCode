/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example-1

```
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
Output: ["KFC","Burger King","Tapioca Express","Shogun"]
```

Example-2

```
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
```

Tags
Array, Hash Table, String

Solution
Hash Table
 */
class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		int length1 = list1.length, length2 = list2.length;
		int indexSum = length1 - 1 + length2 - 1;
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < length1; i++) {
			if (map.containsKey(list1[i]) == false) {
				map.put(list1[i], i);
			}
		}

		for (int i = 0; i < length2; i++) {
			Integer index = map.get(list2[i]);
			if (index != null) {
				if (index + i < indexSum) {
					list = new ArrayList<>();
					list.add(list2[i]);
					indexSum = index + i;
				} else if (index + i == indexSum) {
					list.add(list2[i]);
				}
			}
		}

		String[] ans = new String[list.size()];
		return list.toArray(ans);
	}
}
