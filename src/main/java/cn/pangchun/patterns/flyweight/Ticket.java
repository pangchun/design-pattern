package cn.pangchun.patterns.flyweight;

/**
 * 车票接口：展示车票信息
 * 
 * @author pangchun
 * @since 2023/10/25
 */
public interface Ticket {

    /**
     * 展示车票信息
     * @param bunk 铺位，分为上铺、下铺、坐票
     */
    void showTicketInfo(String bunk);
}
