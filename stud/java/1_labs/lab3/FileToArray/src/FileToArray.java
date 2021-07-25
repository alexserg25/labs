import com.firstname_lastname.java.lesson3.FileArrayOperation;

import java.util.HashMap;
import java.util.Set;

public class FileToArray {
    public static void main(String[] args) {
        FileToArray fileToArray = new FileToArray();
        fileToArray.startFileToArray();
    }

    private void startFileToArray() {
        String fileName = "fileList.txt";

        FileArrayOperation operation = new FileArrayOperation();
        HashMap<Integer, String> objectList;

        objectList = operation.getObjectList(fileName);

        Set<Integer> keys = objectList.keySet();
        HashMap<Integer, String> uniqueObjectList = new HashMap<>();
        for (int key: keys) {
            if (!uniqueObjectList.containsValue(objectList.get(key))) {
                uniqueObjectList.put(key, objectList.get(key));
            }
        }

        System.out.println("Not unique list: " + objectList);
        System.out.println("Unique list: " + uniqueObjectList);
    }

}
