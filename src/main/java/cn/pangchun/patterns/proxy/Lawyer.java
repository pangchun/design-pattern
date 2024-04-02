package cn.pangchun.patterns.proxy;

/**
 * 代理律师
 * 
 * @author pangchun
 * @since 2023/10/25
 */
public class Lawyer implements ILawsuit {
    private ILawsuit iLawsuit;

    public Lawyer(ILawsuit iLawsuit) {
        this.iLawsuit = iLawsuit;
    }

    @Override
    public void submit() {
        iLawsuit.submit();
    }

    @Override
    public void burden() {
        iLawsuit.burden();
    }

    @Override
    public void defend() {
        iLawsuit.defend();
    }

    @Override
    public void finish() {
        iLawsuit.finish();
    }
}
