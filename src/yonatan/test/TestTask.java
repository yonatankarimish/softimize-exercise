package yonatan.test;

import yonatan.domain.*;

import java.util.Date;

/**
 * Created by Yonatan on 06/12/2016.
 */
public class TestTask implements Runnable {

    private static PersonCollection hardWorkingCollection = new PersonCollection();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for(int i=0; i<100; i++){
            IPerson p = new SimplePerson(-1, threadName+"_name_"+i, threadName+"_lastName_"+i, new Date(), 180);
            hardWorkingCollection.add(p);
        }

        System.out.println("Thread "+Thread.currentThread().getName()+" is printing after adding 1000 people");
        hardWorkingCollection.printCollection();

        for(int i=0; i<10; i++){
            hardWorkingCollection.remove();
        }

        System.out.println("Thread "+Thread.currentThread().getName()+" is printing after removing 1000 people");
        hardWorkingCollection.printCollection();
    }
}