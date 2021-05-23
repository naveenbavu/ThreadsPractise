package schedulerexp;

import java.io.File;

/**
 * @author Naveen Bavu
 */
public class CleaningSchduler implements Runnable{

  @Override
  public void run() {
    ///Users/nbavu/Documents/mavenprojects/javasamples/mtb/src/schedulerexp/files
    System.out.println("Run");

    File folder = new File("/Users/nbavu/Documents/mavenprojects/javasamples/mtb/src/schedulerexp/files");
    File[] files = folder.listFiles();

    for(File file: files){
      if(System.currentTimeMillis()-file.lastModified()>5*60*1000){
        System.out.println("This file will be deleted "+file.getName());
//        file.delete();

      }

    }

  }
}
