package yonatan.domain;

import java.util.*;

/**
 * Created by Yonatan on 06/12/2016.
 */
public class PersonCollection {
    private List<ISubscriber> observers;
    private List<IPerson> backingList;

    public PersonCollection(){
        this.observers = new ArrayList<>(); //arrayList has get complexity of O(1)
        this.backingList = new LinkedList<>(); //LinkedList has add + remove complexity of O(1)
    }

    public synchronized void add(IPerson person){ // adds the given person to the backing list, by comparison order
        ListIterator<IPerson> it = this.backingList.listIterator();
        while (it.hasNext()) {
            IPerson current = it.next();
            if (person.compareTo(current) <= 0) {
                this.backingList.add(it.previousIndex(), person);
                return;
            }
        }
        this.backingList.add(person);
        this.notifySubscribers(PersonAction.ADD);
    }

    public synchronized void remove(){ //removes the Person with the maximum value, regardless of implementation
        this.backingList.remove(this.backingList.size() - 1); // because the backing list is ordered, simply remove the last implementation. complexity O(1);
        this.notifySubscribers(PersonAction.REMOVE);
    }

    public synchronized void registerSubscriber(ISubscriber observer){
        this.observers.add(observer);
    }

    public synchronized void removeSubscriber(ISubscriber observer){
        this.observers.remove(observer);
    }

    private void notifySubscribers(PersonAction action){
        for(ISubscriber observer : observers){
            observer.update(this, action);
        }
    }

    public synchronized void printCollection(){
        System.out.print("[");
        for (IPerson person : this.backingList)
            System.out.print(person + ", ");
        System.out.println("]");
    }
}
