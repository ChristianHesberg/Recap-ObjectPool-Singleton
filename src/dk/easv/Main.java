package dk.easv;

public class Main {

    public static void main(String[] args) {
        ObjectPool pool = ObjectPool.getInstance();

        try {
            System.out.println(pool.acquire());
            System.out.println(pool.acquire());
            System.out.println(pool.acquire());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println();
        }

    }
}
