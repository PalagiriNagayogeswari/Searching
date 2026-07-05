import java.io.*;

public class LinearSearchFile {

    public static void main(String[] args) {

        String filePath = "src/large_text_file.txt";
        String targetWord = "java";

        String[] words = readWords(filePath);

        if (words == null) {
            System.out.println("Unable to read file.");
            return;
        }

        int index = linearSearch(words, targetWord);

        if (index != -1)
            System.out.println("Word \"" + targetWord + "\" found at index " + index);
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

    static int linearSearch(String[] words, String target) {

        target = target.toLowerCase();

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(target))
                return i;
        }

        return -1;
    }
}