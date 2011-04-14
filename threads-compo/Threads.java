public class Threads {

    static class HelloThread implements Runnable {
        public void run() { 
            System.out.println("Hello world");
            try {
                Thread.sleep(1000);
            } catch (Exception ex) { 
                ex.printStackTrace();
            }
        }
    }

    public static void main(String... args) throws Exception {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(new HelloThread());
            thread.start();
        }

        long stop = System.currentTimeMillis();

        System.out.println("Executed in: " + (stop - start) + "ms");

    }

}
