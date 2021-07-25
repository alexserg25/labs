import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();

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

//                fileOperation.diffFiles(file1, file2);
                Resources res = new Resources();
                res.setFileName1(file1);
                res.setFileName2(file2);

                ReadFile1 readFile1 = new ReadFile1();
                readFile1.setResources(res);
                readFile1.start();

                ReadFile2 readFile2 = new ReadFile2();
                readFile2.setResources(res);
                readFile2.start();

                DiffFiles diffFiles = new DiffFiles();
                diffFiles.setResources(res);
                diffFiles.start();

                if (diffFiles.isAlive()) {
                    try {
                        diffFiles.join();
                    } catch (InterruptedException e) {}
                }

                runTime = System.currentTimeMillis() - startTime;
                listRunTime.put(mess, runTime);
                listKey.add(mess);

                countLines = (countLines < 1000) ? (countLines + 200) : (countLines * 3);
            }

            countLetters = (countLetters < 1000) ? (countLetters + 200) : (countLetters * 2);
        }

        System.out.println("=".repeat(100));

        for (String key: listKey) {
            runTime = listRunTime.get(key);
            System.out.println(key + "Time running = " + runTime);
        }

//        Resources res = new Resources();
//        res.setFileName1(file1);
//        res.setFileName2(file2);

//        ReadFile1 readFile1 = new ReadFile1();
//        readFile1.setResources(res);
//        readFile1.start();

//        ReadFile2 readFile2 = new ReadFile2();
//        readFile2.setResources(res);
//        readFile2.start();

//        DiffFiles diffFiles = new DiffFiles();
//        diffFiles.setResources(res);
//        diffFiles.start();

    }
}

class Resources {
    volatile int positionFile1 = 0;
    volatile int positionFile2 = 0;
    volatile int positionDiffFiles = 0;
    volatile boolean isEndFile1 = false;
    volatile boolean isEndFile2 = false;

    String lineFile1 = "";
    String lineFile2 = "";

    String fileName1 = "";
    String fileName2 = "";

    public void setFileName1(String fileName1) {
        this.fileName1 = fileName1;
    }
    public void setFileName2(String fileName1) {
        this.fileName2 = fileName1;
    }

    public synchronized void readFile1() {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName1));

            String line = "";
            boolean isActive = false;
            int numRow = 0;
            do {

                while (positionDiffFiles < positionFile1) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                    }
                }

                numRow++;
                line = reader.readLine();

                if (line != null) {
                    isActive = true;
                } else isActive = false;

                if (line == null) line = "\t==> Empty string! <==";

                positionFile1 = numRow;
                lineFile1 = line;

                notifyAll();
            } while (isActive);
            isEndFile1 = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {}
        }
    }
    public synchronized void readFile2() {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName2));

            String line = "";
            boolean isActive = false;
            int numRow = 0;
            do {

                while (positionDiffFiles < positionFile2) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                    }
                }

                numRow++;
                line = reader.readLine();

                if (line != null) {
                    isActive = true;
                } else isActive = false;

                if (line == null) line = "\t==> Empty string! <==";

                positionFile2 = numRow;
                lineFile2 = line;

                notifyAll();
            } while (isActive);
            isEndFile2 = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {}
        }
    }

    public synchronized void compareString() {
        while ((positionFile1 == positionDiffFiles && !isEndFile1)
                || (positionFile2 == positionDiffFiles && !isEndFile2)) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }

        if (isEndFile1) {
            lineFile1 = "\t==> Empty string! <==";
        }
        if (isEndFile2) {
            lineFile2 = "\t==> Empty string! <==";
        }

        positionDiffFiles++;
        if (!lineFile1.equals(lineFile2)) {
            System.out.println("\nRow num : " + (positionDiffFiles));
            System.out.println("file1 = " + lineFile1);
            System.out.println("file2 = " + lineFile2);
        }

        notifyAll();
    }

}

class ReadFile1 extends Thread {
    Resources res;

    public void setResources(Resources resources) {
        res = resources;
    }

    @Override
    public void run() {
        res.readFile1();
    }
}

class ReadFile2 extends Thread {
    Resources res;

    public void setResources(Resources resources) {
        res = resources;
    }

    @Override
    public void run() {
        res.readFile2();
    }
}

class DiffFiles extends Thread {
    Resources res;
    public void setResources(Resources resources) {
        res = resources;
    }


    @Override
    public void run() {
        while (!res.isEndFile1 || !res.isEndFile2) {
            res.compareString();
        }
    }
}
