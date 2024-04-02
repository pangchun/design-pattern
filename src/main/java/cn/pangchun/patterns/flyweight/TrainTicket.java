package cn.pangchun.patterns.flyweight;

import java.util.Random;

/**
 * 具体的火车票
 *
 * @author pangchun
 * @since 2023/10/25
 */
public class TrainTicket implements Ticket {

    private String from; // 起始地
    private String to; // 目的地
    private String bunk; // 铺位
    private int price; // 铺位

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showTicketInfo(String bunk) {
        price = new Random().nextInt(300);
        System.out.println("购买从 " + from + " 到 " + to + " 的 " + bunk + " 火车票 " + ", 价格: " + price);
    }
}
