package site.laodengtou.taobao01.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int one;
    private int two;
    private int three;
    private int four;
    private Boolean cCheck;
    private Date checkTime;

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getThree() {
        return three;
    }

    public void setThree(int three) {
        this.three = three;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public Boolean getcCheck() {
        return cCheck;
    }

    public void setcCheck(Boolean cCheck) {
        this.cCheck = cCheck;
    }
}
