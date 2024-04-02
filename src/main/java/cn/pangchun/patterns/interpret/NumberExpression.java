package cn.pangchun.patterns.interpret;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数字解释器：仅仅解释数字
 * 
 * @author pangchun
 * @since 2023/10/12
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NumberExpression extends ArithmeticExpression {

    private int num;

    @Override
    public int interpret() {
        return num;
    }
}
