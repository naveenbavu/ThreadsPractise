package schedulerexp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Naveen Bavu
 */
public class TestScheduler {

  public static void main(String[] args) {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//    service.schedule(new CleaningSchduler(),5, TimeUnit.SECONDS);
    service.scheduleAtFixedRate(new CleaningSchduler(),5,4,TimeUnit.SECONDS);
  }

}
