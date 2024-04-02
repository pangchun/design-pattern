package cn.pangchun.patterns.responsibility.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 费用报销请求对象
 *
 * @author pangchun
 * @since 2023/10/8
 */
@Data
@AllArgsConstructor
public class BillApplyRequest {

    /**
     * 申请人
     */
    private String username;

    /**
     * 申请金额
     */
    private BigDecimal bill;
}
