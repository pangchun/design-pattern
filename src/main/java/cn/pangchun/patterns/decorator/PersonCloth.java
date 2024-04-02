package cn.pangchun.patterns.decorator;

/**
 * 装饰者：需要保持一个对被装饰者的引用
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public abstract class PersonCloth extends Person {

    protected Person person;

    public PersonCloth(Person person) {
        this.person = person;
    }

    @Override
    public void dressed() {
        person.dressed();
    }
}
