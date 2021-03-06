
public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.startApp();
    }

    private void startApp() {

        long startTime = 0;
        long endTime = 0;

        Resource resource = new Resource();
        resource.insertDataArray();

        WriterData writerData;
        ReaderData readerData;

        resource.setSizeBuffer(2);
        //resource.setSizeArray(10000000);
        int sizeBuffer = resource.getSizeBuffer();
        int sizeArray = resource.getSizeArray();

        while (sizeBuffer < sizeArray/2) {
            startTime = System.currentTimeMillis();

            sizeBuffer *= 5;
            if (sizeBuffer > sizeArray/2) {
                sizeBuffer = sizeArray/2;
            }
            resource.setSizeBuffer(sizeBuffer);

            resource.cleanResource();

            writerData = new WriterData();
            writerData.setName("Writer Data");
            writerData.setResource(resource);

            readerData = new ReaderData();
            readerData.setName("Reader Data");
            readerData.setResource(resource);

            readerData.start();
            writerData.start();

            if (readerData.isAlive()) {
                try {
                    readerData.join();
                } catch (InterruptedException e) {}
            }

            if (writerData.isAlive()) {
                try {
                    writerData.join();
                } catch (InterruptedException e) {}
            }

            endTime = System.currentTimeMillis();

            System.out.println("Buffer size = " + sizeBuffer);
            System.out.println("Run time = " + (endTime - startTime));

        }
    }
}
class Resource {
    private int sizeArray = (int) Math.pow(10, 8);

    private int[] a = new int[sizeArray];
    private int[] b = new int[sizeArray];
    private int[] buffer = new int[sizeArray / 2];

    private int sizeBuffer = 0;
    private int recordReader = 0;
    private int recordWriter = 0;

    public int getSizeArray() {
        return sizeArray;
    }
    public synchronized void setSizeArray(int size) {
        sizeArray = size;
    }
    public int getSizeBuffer() {
        return sizeBuffer;
    }
    public synchronized void setSizeBuffer(int size) {
        sizeBuffer = size;
    }
    public int getRecordReader() {
        return recordReader;
    }
    public synchronized void setRecordReader(int value) {
        recordReader = value;
    }
    public synchronized void incRecordReader() {
        recordReader++;
    }
    public int getRecordWriter() {
        return recordWriter;
    }
    public synchronized void setRecordWriter(int value) {
        recordWriter = value;
    }
    public synchronized void incRecordWriter() {
        recordWriter++;
    }
    public int getBuffer(int positionArray) {
        return buffer[positionArray];
    }
    public synchronized void setBuffer(int value, int positionArray) {
        buffer[positionArray] = value;
    }
    public int getA(int positionArray) {
        return a[positionArray];
    }
    public synchronized void setB(int value, int positionArray) {
        b[positionArray] = value;
    }
    public synchronized void cleanResource() {
        recordReader = 0;
        recordWriter = 0;
    }

    public int getCounterReader() {
        int res = recordReader % sizeBuffer;
        return res;
    }

    public int getCounterWriter() {
        int res = recordWriter % sizeBuffer;
        return res;
    }

    public synchronized void insertDataArray() {
        for (int i = 0; i < sizeArray; i++) {
            a[i] = Integer.MAX_VALUE;
        }
    }

}

class WriterData extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        int counter = 0;

        int sizeArray = resource.getSizeArray();
        int recordWriter = resource.getRecordWriter();
        int recordReader;

        while (recordWriter < sizeArray) {
            recordReader = resource.getRecordReader();
            if (recordWriter < recordReader) {

                counter = resource.getCounterWriter();
                resource.setB(resource.getBuffer(counter), recordWriter);

                resource.setRecordWriter(++recordWriter);
//                resource.incRecordWriter();
//                recordWriter = resource.getRecordWriter();
                recordReader = resource.getRecordReader();

//                System.out.println("Record Writer = " + recordWriter);
            }
            else {
                Thread.yield();
//                try {
//                    sleep(2);
//                } catch (Exception e) {}
            }
        }
    }
}

class ReaderData extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        int counter = 0;

        int sizeArray = resource.getSizeArray();
        int recordReader = resource.getRecordReader();
        int sizeBuffer = resource.getSizeBuffer();
        int recordWriter;

        while (recordReader < sizeArray) {
            recordWriter = resource.getRecordWriter();
            if (recordReader < recordWriter + sizeBuffer) {

                counter = resource.getCounterReader();
                resource.setBuffer(resource.getA(recordReader), counter);

                resource.setRecordReader(++recordReader);
//                resource.incRecordReader();
//                recordReader = resource.getRecordReader();
                recordWriter = resource.getRecordWriter();

//                System.out.println("Record Reader = " + recordReader);
            }
            else {
                Thread.yield();
//                try {
//                    sleep(2);
//                } catch (Exception e) {}
            }
        }

    }
}
