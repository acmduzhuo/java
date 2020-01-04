package One;


import java.util.Random;


public class Main implements Runnable {

   public int total;

   public int count;

   public Main() {

      total = 50;

       count = 0;

   }



   public void run() {

       while (total > 0) {

           synchronized (this) {

               if(total > 0) {
                   try {

                       //Thread.sleep(800);

                       Thread.sleep(new Random().nextInt(1000));

                   } catch (InterruptedException e) {

                       e.printStackTrace();
                   }

                   count++;
                   total--;

                   System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);

               }

           }

       }

   }


   public static void main(String[] args) {

       Main st = new Main();

       for(int i=1; i<=5; i++) {

           new Thread(st, "售票点" + i).start();

       }

   }

}

