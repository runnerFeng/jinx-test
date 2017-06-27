package com.commonTest.demo8_threadLocal;

/**
 * Desc:当前线程变量
 * Created by jinx on 2017/3/31.
 */
public class TestNum {

     private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
          @Override
          protected Integer initialValue() {
               return 0;
          }
     };

     public int getNextNum(){
          seqNum.set(seqNum.get()+1);
          return seqNum.get();
     }

     public static void main(String[] args) {
          //每一个线程中的值都是独立的，互不影响
          TestNum tn = new TestNum();
          TestClient t1 = new TestClient(tn);
          TestClient t2 = new TestClient(tn);
          TestClient t3 = new TestClient(tn);
          t1.start();
          t2.start();
          t3.start();

     }

     private static class TestClient extends Thread {
          private TestNum tn;

          public TestClient(TestNum tn){
               this.tn = tn;
          }

          @Override
          public void run() {
               for (int i = 0; i < 3; i++) {
               System.out.println("thread["+Thread.currentThread().getName()+"]-->"+"tn["+tn.getNextNum()+"]");
               }
          }
     }

}

