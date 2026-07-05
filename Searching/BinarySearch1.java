public class BinarySearch1 {
    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 1, 2, 3};

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println("Rotation Index = " + left);
        System.out.println("Smallest Element = " + arr[left]);
    }
}