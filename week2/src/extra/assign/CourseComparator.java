package extra.assign;

import java.util.Comparator;

public class CourseComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Course c1 = (Course) o1;
        Course c2 = (Course) o2;
        return Integer.compare(c1.getId(), c2.getId());
    }
}
