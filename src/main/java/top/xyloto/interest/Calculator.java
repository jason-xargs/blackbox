package top.xyloto.interest;

/**
 * @author zhaocong05
 * @createTime 2017-10-12
 * @description Calculator
 */
public class Calculator {


    /**
     * 一次缴纳复利计算
     *
     * @param duration 年限
     * @param money    投入
     * @param rate     年利率
     * @return
     */
    public static Result calculate4once(int duration, double money, double rate) {
        double future = money;
        for (int i = 0; i < duration; i++) {
            future = future * (1 + rate);
        }
        return new Result(money, future);
    }

    /**
     * 每年缴纳复利计算
     *
     * @param duration     年限
     * @param moneyPerYear 每年投入
     * @param rate         年利率
     * @return
     */
    public static Result calculate4perYear(int duration, double moneyPerYear, double rate) {

        double invest = 0;
        double future = moneyPerYear;
        for (int i = 0; i < duration; i++) {
            future = future * (1 + rate) + moneyPerYear;
            invest += moneyPerYear;
        }
        return new Result(invest, future);

    }

    /**
     * 每年提取复利计算
     *
     * @param decreasePerYear 每年提取
     * @param rate            年利率
     * @param initial         初始金额
     * @return
     */
    public static DecreaseResult calculate4perYearDecrease(double decreasePerYear, double rate, double initial) {

        double after = initial;
        int duration = 0;
        while (after > decreasePerYear && duration < 100) {
            after = after * (1 + rate) - decreasePerYear;
            duration++;
        }
        return new DecreaseResult(initial, duration, after, decreasePerYear);
    }

}
