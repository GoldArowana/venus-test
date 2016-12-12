package cn.com.mx.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jyw
 * @since 2016-11-28.
 */
public class AutoCollectRefactorSample {
    private static List<String> nonTrivialOperarion(Map<String, List<String>> map) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            if (entry.getKey().isEmpty()) continue;
            List<String> list = entry.getValue();
            if (list == null) continue;
            for (String str: list) {
                String trimmed = str.trim();
                if (trimmed.isEmpty()) continue;
                result.add(trimmed);
            }
        }
        return result;
    }
}
