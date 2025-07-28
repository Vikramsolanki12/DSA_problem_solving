import java.util.*;

public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) return res;

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, wordSet, graph, distance);
        dfs(beginWord, endWord, graph, distance, new ArrayList<>(), res);
        return res;
    }

    private static void bfs(String start, String end, Set<String> wordSet,
                            Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String neighbor : getNeighbors(word, wordSet)) {
                    graph.computeIfAbsent(word, x -> new ArrayList<>()).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(word) + 1);
                        if (neighbor.equals(end)) found = true;
                        else queue.add(neighbor);
                    }
                }
            }
            if (found) break;
        }
    }

    private static void dfs(String word, String end, Map<String, List<String>> graph,
                            Map<String, Integer> distance, List<String> path, List<List<String>> res) {
        path.add(word);
        if (word.equals(end)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String next : graph.getOrDefault(word, new ArrayList<>())) {
                if (distance.get(next) == distance.get(word) + 1)
                    dfs(next, end, graph, distance, path, res);
            }
        }
        path.remove(path.size() - 1);
    }

    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char old = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chs[i] = c;
                String next = new String(chs);
                if (wordSet.contains(next) && !next.equals(word))
                    res.add(next);
            }
            chs[i] = old;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders("hit", "cog", wordList));
    }
}
