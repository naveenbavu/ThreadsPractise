package threadsexp.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Naveen Bavu
 */
public class AssignTaskManagerTest {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(2);

    DevTeam devTeamA = new DevTeam(countDownLatch, "Dev-A");
    DevTeam devTeamB = new DevTeam(countDownLatch, "Dev-B");

    devTeamA.start();
    devTeamB.start();
    System.out.println("Get count :"+countDownLatch.getCount());
    countDownLatch.await(1000, TimeUnit.MILLISECONDS);

    QATeam qaTeam = new QATeam("QA Team");
    qaTeam.start();

  }

}
