package cn.pangchun.patterns.responsibility.handler.impl;

import cn.pangchun.patterns.responsibility.handler.BillApplyHandler;
import cn.pangchun.patterns.responsibility.request.BillApplyRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * 总经理
 *
 * @author pangchun
 * @since 2023/10/8
 */
@Slf4j
public class CeoHandler implements BillApplyHandler {

    @Override
    public Boolean support(BillApplyRequest req) {
        return true;
    }

    @Override
    public Boolean process(BillApplyRequest req) {
        log.info("申请结果：通过；" +
                        "处理人：总经理；" +
                        "申请人：{}；" +
                        "申报金额：{}",
                req.getUsername(), req.getBill());
        return true;
    }
}
