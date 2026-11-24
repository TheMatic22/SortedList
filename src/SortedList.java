import java.util.ArrayList;
public class SortedList {
    private ArrayList<String> items;

    public SortedList(){
        items = new ArrayList<>();
    }
    private int binarySearch(String target) {
        int low = 0;
        int high = items.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = target.compareTo(items.get(mid));

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -(low + 1);
    }

    public void add(String value) {
        int result = binarySearch(value);
        int insertAt;

        if (result >= 0) {
            insertAt = result;
        } else {
            insertAt = -(result + 1);
        }

        items.add(insertAt, value);
    }

    public String search(String target) {
        int result = binarySearch(target);

        if (result >= 0) {
            return "Found \"" + items.get(result) + "\" at index " + result;
        } else {
            int position = -(result + 1);
            return "\"" + target + "\" not found. It would be inserted at index " + position;
        }
    }
    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < items.size(); i++) {
            sb.append(i).append(": ").append(items.get(i)).append("\n");
        }

        return sb.toString();
    }
}
