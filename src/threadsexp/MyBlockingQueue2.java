package threadsexp;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue2<E> {
 private Queue<E> queue;
 private Object notFull;
 private Object notEmpty;
 private int max;

 public MyBlockingQueue2(Queue<E> queue, int size) {
  this.queue = new LinkedList<>();
  this.max = size;
 }

 // producer
 public void put(E e) throws InterruptedException {
  synchronized (this) {
   while (queue.size() == max) {
    notFull.wait();
   }
   queue.add(e);
   notEmpty.notifyAll();
  }
 }

 // consumer
 public E take() throws InterruptedException {
  synchronized (this) {
   while (queue.size() == 0) {
    notEmpty.wait();
   }
   E e = queue.remove();
   notFull.notifyAll();
   return e;
  }
 }
}