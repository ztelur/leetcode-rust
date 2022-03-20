package again;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 生成一个 Map，Map 的 key 是排序后的key，value就是列表
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // toArrays()
            char[] array = str.toCharArray();
            // Arrays.sort(array)
            Arrays.sort(array);
            String key = new String(array);
            // 获取然后返回
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
