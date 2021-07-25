import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class FileOperation {
    public void generationFile(String fileName, int countLetters, int countLines) {
        StringOperation stringOperation = new StringOperation();
        ArrayList<String> listLine = new ArrayList<>();

        for (int i = 1; i <= countLines; i++) {
//            countLetters = 2 + (int) (Math.random() * (countLetters - 2));
            String str = stringOperation.generationString(countLetters);
            listLine.add(str);
        }

        writeFile(listLine, fileName);
    }

    private void writeFile(ArrayList<String> listLine, String fileName) {

        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(fileName, false);

            for (String str: listLine) {
                fileWriter.write(str);
                fileWriter.append("\r");
                fileWriter.append("\n");
            }

            fileWriter.flush();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) { }
        }
    }

    private boolean isExists(String fileName) {
        Path path = Paths.get(fileName);

        if (Files.exists(path)) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<String> readFile(String fileName) {
        ArrayList<String> listLine = new ArrayList<>();

        if (!isExists(fileName)) {
            return listLine;
        }

        FileReader fileReader = null;
        BufferedReader reader = null;

        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            String line = "";

            while(reader.ready()){
                line = reader.readLine();
                listLine.add(line);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
                fileReader.close();
            } catch (IOException e) {}
        }
        return listLine;
    }

    public void addDiff(String origFiles, String newFile, int countDiffLine) {
        ArrayList<String> listLine;
        StringOperation stringOperation = new StringOperation();

        listLine = readFile(origFiles);
        int numLine = 0;

        // Modify lines
        for (int i = 0; i < countDiffLine; i++) {
            numLine = (int) (Math.random() * listLine.size());
            listLine.set(numLine, stringOperation.generationString(listLine.get(numLine).length()));
        }

        // Add new lines
        int countNewLine = (int) (Math.random() * 10);
        for (int i = 0; i < countNewLine; i++) {
            listLine.add(stringOperation.generationString((int) (Math.random() * 100)));
        }

        // Write to file
        writeFile(listLine, newFile);
    }

    public void diffFiles(String fileName1, String fileName2) {

        BufferedReader reader1 = null;
        BufferedReader reader2 = null;

        try {
            reader1 = new BufferedReader(new FileReader(fileName1));
            reader2 = new BufferedReader(new FileReader(fileName2));

            String line1="";
            String line2="";
            boolean isActive = false;
            int numRow = 0;
            do {
                numRow++;
                line1 = reader1.readLine();
                line2 = reader2.readLine();

                if (line1 != null || line2 != null) {
                    isActive = true;
                } else isActive = false;

                if (line1 == null) line1 = "\t==> Empty string! <==";
                if (line2 == null) line2 = "\t==> Empty string! <==";

                if (!line1.equals(line2)) {
                    System.out.println("\nRow num : " + numRow);
                    System.out.println("file1 = " + line1);
                    System.out.println("file2 = " + line2);
                }
            } while (isActive);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader1.close();
                reader2.close();
            } catch (IOException e) {}
        }
    }
}
