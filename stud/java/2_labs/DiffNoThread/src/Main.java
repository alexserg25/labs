import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.startDiff();
    }

    private void startDiff() {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        int maxCountLetters = 10000;
        int maxCountLines = 100000;

        FileOperation fileOperation = new FileOperation();

        int countLetters = 2;
        int countLines = 0;
        String mess = "";
        long startTime = 0;
        long runTime = 0;
        HashMap<String, Long> listRunTime = new HashMap<>();
        ArrayList<String> listKey = new ArrayList<>();

        while (countLetters <= maxCountLetters) {

            countLines = 10;

            while (countLines <= maxCountLines) {
                mess = "DIFF OPERATION FOR: COUNT LETTERS = \"" + countLetters
                        + "\", COUNT LINES = \"" + countLines + "\". ";
                System.out.println("\n" + mess);

                fileOperation.generationFile(file1, countLetters, countLines);
                fileOperation.addDiff(file1, file2, 3);

                startTime = System.currentTimeMillis();

                fileOperation.diffFiles(file1, file2);

                runTime = System.currentTimeMillis() - startTime;
                listRunTime.put(mess, runTime);
                listKey.add(mess);

                countLines = (countLines < 1000) ? (countLines + 200) : (countLines * 3);
            }

            countLetters = (countLetters < 1000) ? (countLetters + 200) : (countLetters * 2);
        }

        System.out.println("=".repeat(100));
//        Collections.sort(listKey);

        for (String key: listKey) {
            runTime = listRunTime.get(key);
            System.out.println(key + "Time running = " + runTime);
        }
    }
}
