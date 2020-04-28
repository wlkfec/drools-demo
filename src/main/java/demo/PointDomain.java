package demo;

import lombok.Data;

@Data
public class PointDomain {

    // 过生日，则加10分，并且将当月交易比数翻倍后再计算积分
    // 2011-01-08 - 2011-08-08每月信用卡还款3次以上，每满3笔赠送30分
    // 当月购物总金额100以上，每100元赠送10分
    // 当月购物次数5次以上，每五次赠送50分
    // 特别的，如果全部满足了要求，则额外奖励100分
    // 发生退货，扣减10分
    // 退货金额大于100，扣减100分

    // 用户名
    private String userName;
    // 是否当日生日
    private boolean birthDay;
    // 增加积分数目
    private long point;
    // 当月购物次数
    private int buyNums;
    // 当月退货次数
    private int backNums;
    // 当月购物总金额
    private double buyMoney;
    // 当月退货总金额
    private double backMondy;
    // 当月信用卡还款次数
    private int billThisMonth;

    public void recordPointLog(String userName, String type){
        System.out.println("增加对"+userName+"的类型为"+type+"的积分操作记录.");
    }


}
