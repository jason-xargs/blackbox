package top.xyloto.interest;

import com.alibaba.fastjson.JSON;

/**
 * @author zhaocong05
 * @createTime 2017-10-12
 * @description Result
 */
public class Result {

    private double invest;
    private double interest;
    private double future;

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

    public double getFuture() {
        return future;
    }

    public void setFuture(double future) {
        this.future = future;
    }

    public Result(double invest, double future) {
        this.invest = invest;
        this.future = future;
        this.interest = future - invest;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
