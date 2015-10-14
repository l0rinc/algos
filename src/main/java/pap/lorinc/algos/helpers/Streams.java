package pap.lorinc.algos.helpers;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Streams {
    public static <K, V> Stream<Entry<K, V>> stream(Map<K, V> map) {
        return map.entrySet()
                  .stream();
    }
}
