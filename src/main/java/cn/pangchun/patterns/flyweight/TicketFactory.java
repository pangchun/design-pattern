package cn.pangchun.patterns.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 车票工厂
 * 
 * @author pangchun
 * @since 2023/10/25
 */
public class TicketFactory {

    public static Map<String ,Ticket> ticketMap = new ConcurrentHashMap<>();

    public static Ticket getTicket(String from, String to) {
        String key = from + "-" + to;
        if (ticketMap.containsKey(key)) {
            System.out.println("使用缓存 ====> " + key);
            return ticketMap.get(key);
        } else {
            System.out.println("创建对象 ====> " + key);
            final TrainTicket ticket = new TrainTicket(from, to);
            ticketMap.put(key, ticket);
            return ticket;
        }
    }
}
