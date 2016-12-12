package yonatan.domain;

/**
 * Created by Yonatan on 06/12/2016.
 */
public interface ISubscriber {
    void update(Object source, PersonAction action);
}
