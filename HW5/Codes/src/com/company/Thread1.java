package com.company;


// It reads the pixels from the image and inserts them into the three priority queues.
public class Thread1 extends Thread {

    private Pixel[][] arr;
    PriorityQueue PQLEX;
    PriorityQueue PQEUC;
    //Thread2 th2;
    //Thread3 th3;



   public Thread1(Pixel[][] pixel){

       arr=pixel;
       PQLEX = new PriorityQueue(new LEX());
       PQEUC = new PriorityQueue(new EUC());
       //th2= new Thread2(PQLEX);
       //th3= new Thread3(PQEUC);
    }



    @Override
    public void run(){

        System.out.println("Thread1 started running..");


        for (int i=0 ; i<arr[0].length ; ++i){
            for (int j=0; j<arr.length; ++j){

                PQLEX.offer(arr[j][i]);
                PQEUC.offer(arr[j][i]);
                System.out.print("Thread 1:");
                System.out.println(arr[j][i]);

                /*if(i*j==100){

                    System.out.println("Thread2 started running..");
                    th2.run();
                    System.out.println("Thread3 started running..");
                    th3.run();
                }*/

            }
        }


    }




    /*private static class Thread2 extends Thread{

        private PriorityQueue pq;

        public Thread2(PriorityQueue pri_queue){

            pq=pri_queue;
        }

        @Override
        public void run(){

            while(pq.poll()!=null){

                Pixel p=pq.poll();
                System.out.println(p);
            }
        }
    }



    private static class Thread3 extends Thread{

        private PriorityQueue pq;

        public Thread3(PriorityQueue pri_queue){

            pq=pri_queue;
        }

        @Override
        public void run(){

            while(pq.poll()!=null){

                Pixel p=pq.poll();
                System.out.println(p);
            }
        }
    }



    private static class Thread4 extends Thread{

        private PriorityQueue pq;

        public Thread4(PriorityQueue pri_queue){

            pq=pri_queue;
        }

        @Override
        public void run(){

            while(pq.poll()!=null){

                Pixel p=pq.poll();
                System.out.println(p);
            }
        }
    }*/

}
