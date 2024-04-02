package cn.pangchun.patterns.responsibility.handler.impl;

import cn.pangchun.patterns.responsibility.handler.BillApplyHandler;
import cn.pangchun.patterns.responsibility.request.BillApplyRequest;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 主管
 *
 * @author pangchun
 * @since 2023/10/8
 */
@Slf4j
public class ManagerHandler implements BillApplyHandler {

    private static final BigDecimal LIMIT_BILL = BigDecimal.valueOf(30000);

    @Override
    public Boolean support(BillApplyRequest req) {
        return LIMIT_BILL.compareTo(req.getBill()) > 0;
    }

    @Override
    public Boolean process(BillApplyRequest req) {
        final Boolean flag = this.support(req);
        if (!flag) {
            log.info("申请结果：转交下一审核人处理；" +
                            "原因：申报金额过大，当前审核人权限不足；" +
                            "处理人：主管；" +
                            "申请人：{}；" +
                            "申报金额：{}",
                    req.getUsername(), req.getBill());
            return null;
        } else {
            if ("Alan".equalsIgnoreCase(req.getUsername())) {
                log.info("申请结果：未通过；" +
                                "原因：员工是Alan，我对他不爽；" +
                                "处理人：主管；" +
                                "申请人：{}；" +
                                "申报金额：{}",
                        req.getUsername(), req.getBill());
                return false;
            } else {
                log.info("申请结果：通过；" +
                                "处理人：主管；" +
                                "申请人：{}；" +
                                "申报金额：{}",
                        req.getUsername(), req.getBill());
                return true;
            }
        }
    }
}
