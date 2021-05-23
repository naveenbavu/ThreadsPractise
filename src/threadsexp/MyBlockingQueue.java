package threadsexp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

  private Queue<E> queue = new LinkedList<>();
  private ReentrantLock reentrantLock = new ReentrantLock(true);
  private Condition notEmpty = reentrantLock.newCondition();
  private Condition notFull = reentrantLock.newCondition();

  private int max;

  public MyBlockingQueue(int size) {
    this.queue = new LinkedList<>();
    this.max = size;
  }

  // producer
 /*public void put(E e) throws InterruptedException {
  synchronized (this) {
   while (queue.size() == max) {
    notFull.wait();
   }
   queue.add(e);
   notEmpty.notifyAll();
  }
 }*/

  // producer
  public void put(E e) throws InterruptedException {
    reentrantLock.lock();
    try {
      if (queue.size() == max) {
        notFull.wait();
      }
      queue.add(e);
      notEmpty.signalAll();
    } finally {
      reentrantLock.unlock();
    }
  }

  // consumer
  public E take() throws InterruptedException {
    reentrantLock.lock();
    try {
      if (queue.size() == 0) {
        notEmpty.wait();
      }
      E e = queue.remove();
      notFull.notifyAll();
      return e;
    } finally {
      reentrantLock.unlock();
    }
  }
}

/* // consumer
 public E take() throws InterruptedException {
  synchronized (this) {
   while (queue.size() == 0) {
    notEmpty.wait();
   }
   E e = queue.remove();
   notFull.notifyAll();
   return e;
  }
 }*/
