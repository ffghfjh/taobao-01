package site.laodengtou.taobao01.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CodeSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int oneMax;
    private int oneMin;
    private int twoMax;
    private int twoMin;
    private int threeMax;
    private int threeMin;
    private int fourMax;
    private int fourMin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOneMax() {
        return oneMax;
    }

    public void setOneMax(int oneMax) {
        this.oneMax = oneMax;
    }

    public int getOneMin() {
        return oneMin;
    }

    public void setOneMin(int oneMin) {
        this.oneMin = oneMin;
    }

    public int getTwoMax() {
        return twoMax;
    }

    public void setTwoMax(int twoMax) {
        this.twoMax = twoMax;
    }

    public int getTwoMin() {
        return twoMin;
    }

    public void setTwoMin(int twoMin) {
        this.twoMin = twoMin;
    }

    public int getThreeMax() {
        return threeMax;
    }

    public void setThreeMax(int threeMax) {
        this.threeMax = threeMax;
    }

    public int getThreeMin() {
        return threeMin;
    }

    public void setThreeMin(int threeMin) {
        this.threeMin = threeMin;
    }

    public int getFourMax() {
        return fourMax;
    }

    public void setFourMax(int fourMax) {
        this.fourMax = fourMax;
    }

    public int getFourMin() {
        return fourMin;
    }

    public void setFourMin(int fourMin) {
        this.fourMin = fourMin;
    }
}
