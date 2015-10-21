package fair.science.prodigious.com.recycleme.model;

import java.util.Date;

/**
 * Created by Jorge on 20/10/2015.
 */
public class CapInput {

    private String code;

    private int capCount;

    private Date date;

    private User user;

    public CapInput(String code, int capCount, Date date, User user) {
        this.code = code;
        this.capCount = capCount;
        this.date = date;
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public int getCapCount() {
        return capCount;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
