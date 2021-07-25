package com.firstname_lastname.java.lesson3;

/**
 * File operation class
 *
 * @version 1.0
 * @author FIO
 */


import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class FileOperation {

    private enum Os {
        MAC,
        NIX,
        WINDOWS,
        OTHER
    }

    private Os osIs() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.matches("mac.*")) {
            return Os.MAC;
        } else if (os.matches(".*nix") || os.matches(".*nux") || os.equals("aix")) {
            return Os.NIX;
        } else if (os.matches("win.*")) {
            return Os.WINDOWS;
        } else {
            return Os.OTHER;
        }
    }

    public String normalizePath(String path) {
        if (osIs() == Os.NIX || osIs() == Os.MAC) {
            path = path.replaceAll("(/|\\\\)+", "/");
        } else if (osIs() == Os.WINDOWS) {
            path = path.replaceAll("(/|\\\\)+", "\\\\");
        }
        return path;
    }

    public boolean isExists(String fileName) {
        Path path = Paths.get(fileName);

        if (Files.exists(path)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean copyFileByte(String inputFile, String outputFile) {

        if (!isExists(inputFile)) {
            return false;
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        File src = new File(inputFile);
        File dest = new File(outputFile);

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest, false);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            fos.flush();

            return true;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {}
        }
    }

    public ArrayList<String> readFileSymbol(String fileName) {
        ArrayList<String> listString = new ArrayList<>();

        if (!isExists(fileName)) {
            return listString;
        }

        FileReader fileReader = null;
        BufferedReader reader = null;

        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            while(reader.ready()){
                String readLine = reader.readLine();
                if (readLine.matches("===+")) {
                    break;
                }
                listString.add(readLine);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
                fileReader.close();
            } catch (IOException e) {}
        }
        return listString;
    }

    public void writeFileSymbol(ArrayList<String> listString, String fileName) {

        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(fileName, true);

            fileWriter.append("\r");
            fileWriter.append("\n");
            fileWriter.append("\r");
            fileWriter.append("\n");

            for (String str: listString) {
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

}
