import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class group_anagram {

    public static List<List<String>> group_anagram(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String freqString = getFrequencyString(str);

            if (map.containsKey(freqString)) {
                map.get(freqString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(freqString, strList);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String getFrequencyString(String str) {
        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : freq) {
            sb.append('#');
            sb.append(count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = group_anagram(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
