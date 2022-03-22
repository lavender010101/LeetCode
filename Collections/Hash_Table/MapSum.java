class MapSum {
	Map<String, Integer> keyMap;
	Map<String, Integer> prefixMap;

	public MapSum() {
		keyMap = new HashMap<>();
		prefixMap = new HashMap<>();
	}

	public void insert(String key, int val) {
		int diff = val - keyMap.getOrDefault(key, 0), length = key.length();

		String prefix = null;
		keyMap.put(key, val);
		for (int i = 1; i <= length; i++) {
			prefix = key.substring(0, i);

			prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + diff);
		}
	}

	public int sum(String prefix) {
		return prefixMap.getOrDefault(prefix, 0);
	}
}
