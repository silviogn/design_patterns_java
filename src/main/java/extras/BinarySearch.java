package extras;

import java.awt.*;

public class BinarySearch {

    public static void main(String[] args) {
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(search(d, 0, d.length - 1, 30));
        System.out.println(search(d, 0, d.length - 1, 6));
        System.out.println(search(null, 0, d.length - 1, 6));
        int[] d2 = {};
        System.out.println(search(d2, 0, d.length - 1, 6));
    }

    public static boolean search(int[] data, int low, int high, int value) {
        if (data == null || data.length == 0)
            return false;
        int middle = (high + low) / 2;
        if (value == data[middle]) {
            return true;
        } else if (low > high) {
            return false;
        }

        if (value > data[middle]) {
            low = middle + 1;
        } else {
            high = middle - 1;
        }
        return search(data, low, high, value);
    }
}
