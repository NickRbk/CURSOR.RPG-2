package cursor.rybak.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Util class to clone List
 */
public class ListUtil {
    public static <T> List<T> copy(List<T> list) {
        List<T> result = new LinkedList<>();
        result.addAll(list);
        return result;
    }
}

