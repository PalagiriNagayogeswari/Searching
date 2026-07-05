import java.io.*;

public class BinarySearchFile {

    public static void main(String[] args) {

        String filePath = "src/large_text_file.txt";
        String targetWord = "java";

        String[] words = readWords(filePath);

        if (words == null) {
            System.out.println("Unable to read file.");
            return;
        }

        quickSort(words, 0, words.length - 1);

        int index = binarySearch(words, targetWord);

        if (index != -1)
            System.out.println("Word found at index " + index);
        else
            System.out.println("Word not found.");
    }

    static String[] readWords(String filePath) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            StringBuilder sb = new StringBuilder();

            String line;

            while ((line = br.readLine()) != null) {

                line = line.toLowerCase();
                line = line.replaceAll("[^a-zA-Z ]", "");

                sb.append(line).append(" ");
            }

            br.close();

            return sb.toString().split("\\s+");

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }

    static void quickSort(String[] arr, int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);

            quickSort(arr, p + 1, high);
        }
    }

    static int partition(String[] arr, int low, int high) {

        String pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].compareTo(pivot) <= 0) {

                i++;

                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static int binarySearch(String[] words, String target) {

        int left = 0;
        int right = words.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int cmp = words[mid].compareTo(target);

            if (cmp == 0)
                return mid;

            else if (cmp < 0)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return -1;
    }
}