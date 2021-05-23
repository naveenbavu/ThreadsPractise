package threadsexp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Naveen Bavu
 */
public class ProdConsuWithBlockingQueue {

  public static void main(String[] args) {

    BlockingQueue<Item> queue = new ArrayBlockingQueue<Item>(10);
    final Runnable producer = () -> {
      while (true) {
        try {
          queue.put(createItem());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    new Thread(producer).start();
    new Thread(producer).start();

    final Runnable consumer = () -> {
      while (true) {
        try {
          Item i = queue.take();
          process(i);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    new Thread(consumer).start();
    new Thread(consumer).start();


  }

  private static void process(Item i) {
    System.out.println("Item removed " + i.getId() + ":" + System.currentTimeMillis());

  }

  private static Item createItem() {
    Item item = new Item();
    item.setId(1);
    item.setName("naveen");
    return item;
  }

}
