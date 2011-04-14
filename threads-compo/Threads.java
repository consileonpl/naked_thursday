public class Threads {

    public static void main(String... args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                    public void run() { 
                        System.out.println("Hello world");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception ex) { 
                            ex.printStackTrace();
                        }
                    }
                }).start();
        }

        long stop = System.currentTimeMillis();

        System.out.println("Executed in: " + (stop - start) + "ms");
    }

}
