package leetcode.editor.cn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 无重复字符最长子串
 *
 * @author wyw
 * @date 2020/03/10
 */
public class LongestSubstring {

    public static void main(String[] args) {

        System.out.println(solution("pwwkew"));
    }

    private static Map<String, Integer> solution(String str) {
        Map<String, Integer> stringMap = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            String element = String.valueOf(str.charAt(i));
            if (stringMap.containsKey(element)) {
                continue;
            }
            stringMap.put(String.valueOf(str.charAt(i)), i);
        }
        return stringMap;
    }
}
