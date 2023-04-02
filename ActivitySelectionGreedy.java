import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Activity {
    int start, end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "\n start=" + start + ", end=" + end + "";
    }
}

class SortByEnd implements Comparator<Activity> {
    public int compare(Activity a, Activity b) {
        if(a.end < b.end) {
            return a.end;
        } else {
            return b.end;
        }
    }
}

public class ActivitySelectionGreedy {
    public static void main(String[] args) {
        Activity selectedActivity = new Activity(0, 0);
        Activity a1 = new Activity(1, 4);
        Activity a2 = new Activity(3, 5);
        Activity a3 = new Activity(0, 6);
        Activity a4 = new Activity(5, 7);
        Activity a5 = new Activity(3, 8);
        Activity a6 = new Activity(5, 9);
        Activity a7 = new Activity(6, 10);
        Activity a8 = new Activity(8, 11);
        Activity a9 = new Activity(8, 12);
        Activity a10 = new Activity(2, 13);
        Activity a11 = new Activity(12, 14);

        ArrayList<Activity> list = new ArrayList<>();
        ArrayList<Activity> solution = new ArrayList<>();

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.add(a8);
        list.add(a9);
        list.add(a10);
        list.add(a11);

        Collections.sort(list, new SortByEnd());

        for(int i = 0; i < list.size(); i++) {
            Activity currentActivity = list.get(i);

            if(selectedActivity.end < currentActivity.start) {
                solution.add(currentActivity);
                selectedActivity = currentActivity;
            }
        }

        System.out.println(solution);
    }
}
