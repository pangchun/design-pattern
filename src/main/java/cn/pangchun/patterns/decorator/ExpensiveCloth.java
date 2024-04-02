package cn.pangchun.patterns.decorator;

/**
 * 具体的装饰者：昂贵的衣服
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class ExpensiveCloth extends PersonCloth {

    public ExpensiveCloth(Person person) {
        super(person);
    }

    private void dressShirt() {
        System.out.println("穿件短袖");
    }

    private void dressLeather() {
        System.out.println("穿件皮衣");
    }

    private void dressJean() {
        System.out.println("穿条牛仔裤");
    }

    @Override
    public void dressed() {
        super.dressed();
        dressShirt();
        dressLeather();
        dressJean();
    }
}
