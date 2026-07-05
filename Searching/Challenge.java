import java.util.Arrays;

public class Challenge {

    static int firstMissingPositive(int[] arr) {

        Arrays.sort(arr);

        int missing = 1;

        for (int num : arr) {

            if (num == missing)
                missing++;

            else if (num > missing)
                break;
        }

        return missing;
    }

    static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};

        System.out.println("First Missing Positive = " + firstMissingPositive(arr));

        Arrays.sort(arr);

        int target = 4;

        System.out.println("Target Index = " + binarySearch(arr, target));
    }
}