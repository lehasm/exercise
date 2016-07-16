public class BinarySearch {

    public static int search(int[] source, int elem) {
        int low = 0, high = source.length, mid;

        while (low < high) {
            mid = (low + high) >>> 1;

            if (source[mid] == elem) {
                return mid;
            }

            if (source[mid] > elem) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
