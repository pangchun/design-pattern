package cn.pangchun.patterns.template;

/**
 * 程序员的计算机：具体的模板角色
 * 
 * @author pangchun
 * @since 2023/10/18
 */
public class CoderComputer extends AbstractComputer {

    @Override
    protected void login() {
        System.out.println("程序员只需要进行用户和密码验证就行");
    }
}
