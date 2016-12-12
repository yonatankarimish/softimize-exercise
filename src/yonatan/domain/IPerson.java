package yonatan.domain;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Yonatan on 06/12/2016.
 */
public interface IPerson extends Comparable<IPerson> {
    int getId();
    String getFirstName();
    String getLastName();
    Date getDateOfBirth();
    int getHeight();
}
