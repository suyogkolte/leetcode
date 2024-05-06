package Arrays_Pkg;

import java.util.*;

public class Analyse_User_Website_Visit_Pattern{
    public static void main(String[] args) {
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};

        List<String> result = mostVisitedPattern(username, timestamp, website);
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        var map = new HashMap<String, Map<Integer, String>>();

        for (int i = 0; i < username.length; i++) {
            map.computeIfAbsent(username[i], o -> new TreeMap<>()).put(timestamp[i], website[i]);
        }

        var patternCount = new HashMap<String, Integer>();
        var maxPattern = "";
        var maxCnt = 0;
        for (Map<Integer, String> m : map.values()) {
            var list = new ArrayList<>(m.values());
            var uniquePatterns = new HashSet<String>();
            if (list.size() < 3) continue;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        var builder = new StringBuilder();
                        var pattern = builder.append(list.get(i)).append(".")
                                .append(list.get(j)).append(".")
                                .append(list.get(k)).toString();

                        if (uniquePatterns.add(pattern)) {
                            patternCount.merge(pattern, 1, Integer::sum);
                            if (patternCount.get(pattern) > maxCnt || (patternCount.get(pattern) == maxCnt && pattern.compareTo(maxPattern) < 0)) {
                                maxCnt = patternCount.get(pattern);
                                maxPattern = pattern;
                            }
                        }
                    }
                }
            }
        }
        return Arrays.asList(maxPattern.split("\\."));
    }
}