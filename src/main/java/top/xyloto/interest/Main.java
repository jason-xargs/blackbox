package top.xyloto.interest;

/**
 * @author zhaocong05
 * @createTime 2017-10-12
 * @description Main
 */
public class Main {

    public static void main(String[] args) {
        Result increase = Calculator.calculate4perYear(10, 10000, 0.05);
        Result increase_01 = Calculator.calculate4once(5, increase.getFuture(), 0.05);
        DecreaseResult decrease = Calculator.calculate4perYearDecrease(10000, 0.05, increase_01.getFuture());
        System.out.println(increase);
        System.out.println(increase_01);
        System.out.println(decrease);

    }

}
