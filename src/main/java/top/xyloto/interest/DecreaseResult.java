package top.xyloto.interest;

import com.alibaba.fastjson.JSON;

/**
 * @author zhaocong05
 * @createTime 2017-10-12
 * @description DecreaseResult
 */
public class DecreaseResult {

    private int duration;
    private double invest;
    private double interest;
    private double future;
    private double last;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getInvest() {
        return invest;
    }

    public void setInvest(double invest) {
        this.invest = invest;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getFuture() {
        return future;
    }

    public void setFuture(double future) {
        this.future = future;
    }

    public DecreaseResult(double invest, int duration, double last, double decreasePerYear) {
        this.duration = duration;
        this.invest = invest;
        this.last = last;

        this.future = duration * decreasePerYear + last;
        this.interest = this.future - this.invest;

    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
