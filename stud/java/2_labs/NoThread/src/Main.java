
public class Main {

    private int sizeArray = (int) Math.pow(10, 8);
    //private int sizeArray = Integer.MAX_VALUE - 2;
    //private int sizeArray = (int) Math.pow(2, 31);

    private int[] a = new int[sizeArray];
    private int[] b = new int[sizeArray];
    private int[] buffer = new int[sizeArray/2];

    public static void main(String[] args) {
        Main app = new Main();
        app.startApp();

    }

    private void startApp() {

        long startTime = 0;
        long endTime = 0;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < sizeArray; i++) {
            //a[i] = (int) (Math.random() * Integer.MAX_VALUE);
            a[i] = Integer.MAX_VALUE;
        }

        endTime = System.currentTimeMillis();
        //System.out.println("Время формирования массива = " + (endTime - startTime));
        int sizeBuffer = 10;

        while (sizeBuffer < sizeArray/2) {
            System.out.println("Buffer size = " + sizeBuffer);
            System.out.println("Run time = " + copyArray(sizeBuffer));

            sizeBuffer *= 5;
        }
        sizeBuffer = sizeArray/2 - 1;
        System.out.println("Buffer size = " + sizeBuffer);
        System.out.println("Run time = " + copyArray(sizeBuffer) + "\n");

        startTime = System.currentTimeMillis();
        int counter = 0;
        while (counter < sizeArray) {
            b[counter] = a[counter];
            counter++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Copy time no use buffer = " + (endTime - startTime));

    }

    private long copyArray(int sizeBuffer) {

        long startTime = System.currentTimeMillis();

        int recReader = 0;
        int recWrite = 0;
        int counter = 0;

        while (recWrite < sizeArray) {

            // Write buffer
            while (counter < sizeBuffer && recReader < sizeArray) {
                buffer[counter] = a[recReader];
                counter++;
                recReader++;
            }

            // Read buffer
            counter = 0;
            while (counter < sizeBuffer && recWrite < recReader) {
                b[recWrite] = buffer[counter];
                counter++;
                recWrite++;
            }
        }
        long endTime = System.currentTimeMillis();
        long workTime = endTime - startTime;

        return workTime;
    }
}
