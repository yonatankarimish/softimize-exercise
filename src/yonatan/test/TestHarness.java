package yonatan.test;

import yonatan.domain.*;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yonatan on 06/12/2016.
 */
public class TestHarness {
    public static void main(String[] args){
        PersonCollection testCollection = new PersonCollection();
        IPerson p1 = new SimplePerson(1, "Raj", "Baljit", new Date(1971, 3, 11), 168);
        IPerson p2 = new SimplePerson(2, "Wilfred", "Owen", new Date(1972, 8, 21), 179);
        IPerson p3 = new SimplePerson(3, "Florence", "Nightingale", new Date(1954, 7, 9), 156);
        IPerson p4 = new SimplePerson(4, "Ayn", "Rand", new Date(1966, 1, 3), 162);
        IPerson p5 = new SimplePerson(5, "Hojo", "Tokimune", new Date(1945, 12, 25), 159);

        ISubscriber s1 = new StandardSubscriber("FOX");
        ISubscriber s2 = new StandardSubscriber("BBC");
        ISubscriber s3 = new StandardSubscriber("CNN");

        testCollection.registerSubscriber(s1);
        testCollection.registerSubscriber(s2);
        testCollection.registerSubscriber(s3);

        testCollection.add(p1);
        testCollection.add(p2);
        testCollection.add(p3);
        testCollection.add(p4);
        testCollection.add(p5);

        System.out.println("Collection after initialization:"); //Test that the person collection is ordered
        testCollection.printCollection();

        testCollection.remove();
        testCollection.remove();

        System.out.println("Collection after removal:");
        testCollection.printCollection();

        IPerson p6 = new SimplePerson(4, "Ghandi", "Mahatma", new Date(1981, 4, 7), 162);
        IPerson p7 = new SimplePerson(5, "Bernard", "Maastrict", new Date(1987, 10, 19), 159);
        testCollection.add(p6);
        testCollection.add(p7);

        System.out.println("Collection after more insertion:");
        testCollection.printCollection();

        testCollection.removeSubscriber(s1);
        testCollection.removeSubscriber(s2);
        testCollection.removeSubscriber(s3);

        ExecutorService pool = Executors.newCachedThreadPool(); // test that the PersonCollection is thread safe
        try {
            for (int i = 0; i < 10; i++) {
                TestTask worker = new TestTask();
                pool.submit(worker);
            }
        }finally {
            pool.shutdown(); // ensure thread pool is released for Garbage Collection
        }
    }
}

