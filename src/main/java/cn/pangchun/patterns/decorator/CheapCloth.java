package cn.pangchun.patterns.decorator;

/**
 * 具体的装饰者：便宜的衣服
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class CheapCloth extends PersonCloth {

    public CheapCloth(Person person) {
        super(person);
    }

    private void dressShorts() {
        System.out.println("穿条短裤");
    }

    @Override
    public void dressed() {
        super.dressed();
        dressShorts();
    }
}
