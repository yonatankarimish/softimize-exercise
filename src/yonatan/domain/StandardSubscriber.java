package yonatan.domain;

/**
 * Created by Yonatan on 06/12/2016.
 */
public class StandardSubscriber implements ISubscriber {
    private String name;

    public StandardSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Object source, PersonAction action) {
        System.out.println(this.name+" has been notified that "+source.toString()+" has performed the following action: "+action);
    }
}
