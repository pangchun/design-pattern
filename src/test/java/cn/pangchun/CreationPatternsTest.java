package cn.pangchun;

import cn.pangchun.patterns.abstract_factory.BmwFactory;
import cn.pangchun.patterns.abstract_factory.GeelyFactory;
import cn.pangchun.patterns.builder.Director;
import cn.pangchun.patterns.builder.MacbookBuilder;
import cn.pangchun.patterns.factory.ConcreteProductA;
import cn.pangchun.patterns.factory.ConcreteProductB;
import cn.pangchun.patterns.factory.FactoryA;
import cn.pangchun.patterns.factory.Product;
import cn.pangchun.patterns.prototype.WordDocument;
import cn.pangchun.patterns.singleton.DclRecycleBin;
import cn.pangchun.patterns.singleton.HungryRecycleBin;
import cn.pangchun.patterns.singleton.LazyRecycleBin;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创建型设计模式-测试类
 *
 * @author pangchun
 * @since 2023/10/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
@Slf4j
public class CreationPatternsTest {

    /**
     * 饿汉式单例模式
     */
    @Test
    @SneakyThrows
    public void testHungrySingleton() {
        final HungryRecycleBin recycleBin1 = HungryRecycleBin.getInstance();
        final HungryRecycleBin recycleBin2 = HungryRecycleBin.getInstance();
        final HungryRecycleBin recycleBin3 = HungryRecycleBin.getInstance();

        System.out.println("recycleBin1.toString() = " + recycleBin1.toString());
        System.out.println("recycleBin2.toString() = " + recycleBin2.toString());
        System.out.println("recycleBin3.toString() = " + recycleBin3.toString());

        // 打印结果：三个对象的内存地址一致，说明是同一个实例
        // recycleBin1.toString() = cn.pangchun.patterns.singleton.HungryRecycleBin@484a5ddd
        // recycleBin2.toString() = cn.pangchun.patterns.singleton.HungryRecycleBin@484a5ddd
        // recycleBin3.toString() = cn.pangchun.patterns.singleton.HungryRecycleBin@484a5ddd
    }

    /**
     * 懒汉式单例模式
     */
    @Test
    @SneakyThrows
    public void testLazySingleton() {
        final LazyRecycleBin recycleBin1 = LazyRecycleBin.getInstance();
        final LazyRecycleBin recycleBin2 = LazyRecycleBin.getInstance();
        final LazyRecycleBin recycleBin3 = LazyRecycleBin.getInstance();

        System.out.println("recycleBin1.toString() = " + recycleBin1.toString());
        System.out.println("recycleBin2.toString() = " + recycleBin2.toString());
        System.out.println("recycleBin3.toString() = " + recycleBin3.toString());

        // 打印结果：三个对象的内存地址一致，说明是同一个实例
        // recycleBin1.toString() = cn.pangchun.patterns.singleton.LazyRecycleBin@5bdb9c69
        // recycleBin2.toString() = cn.pangchun.patterns.singleton.LazyRecycleBin@5bdb9c69
        // recycleBin3.toString() = cn.pangchun.patterns.singleton.LazyRecycleBin@5bdb9c69
    }

    /**
     * DCL单例模式
     */
    @Test
    @SneakyThrows
    public void testDclSingleton() {
        final DclRecycleBin recycleBin1 = DclRecycleBin.getInstance();
        final DclRecycleBin recycleBin2 = DclRecycleBin.getInstance();
        final DclRecycleBin recycleBin3 = DclRecycleBin.getInstance();

        System.out.println("recycleBin1.toString() = " + recycleBin1.toString());
        System.out.println("recycleBin2.toString() = " + recycleBin2.toString());
        System.out.println("recycleBin3.toString() = " + recycleBin3.toString());

        // 打印结果：三个对象的内存地址一致，说明是同一个实例
        // recycleBin1.toString() = cn.pangchun.patterns.singleton.DclRecycleBin@37e64e37
        // recycleBin2.toString() = cn.pangchun.patterns.singleton.DclRecycleBin@37e64e37
        // recycleBin3.toString() = cn.pangchun.patterns.singleton.DclRecycleBin@37e64e37
    }

    /**
     * 原型模式-浅克隆
     */
    @Test
    @SneakyThrows
    public void testShallowPrototype() {
        // 构建文档对象
        final WordDocument originDoc = new WordDocument();
        // 编辑文档
        originDoc.setText("这是一篇文档");
        originDoc.addImage("图片1");
        originDoc.addImage("图片2");
        originDoc.addImage("图片3");
        originDoc.showDocument();

        // 以原始文档为原型，拷贝一份副本
        final WordDocument doc2 = originDoc.clone();
        doc2.showDocument();
        // 修改副本的文本内容，不会影响原文档
        doc2.setText("这是修改过的副本");
        doc2.showDocument();

        originDoc.showDocument();

        // 修改副本的图片，原文档的图片内容也被改变，因为List是引用类型，浅拷贝后，原文档和副本的mImages是同一个对象
        doc2.addImage("图片4");
        doc2.showDocument();

        originDoc.showDocument();
    }

    /**
     * 原型模式-深克隆
     */
    @Test
    @SneakyThrows
    public void testDeepPrototype() {
        // 构建文档对象
        final WordDocument originDoc = new WordDocument();
        // 编辑文档
        originDoc.setText("这是一篇文档");
        originDoc.addImage("图片1");
        originDoc.addImage("图片2");
        originDoc.addImage("图片3");

        // 以原始文档为原型，拷贝一份副本
        final WordDocument doc2 = originDoc.clone();
        // 修改副本的内容
        doc2.setText("这是修改过的副本");
        doc2.addImage("图片4");

        doc2.showDocument();
        originDoc.showDocument();
    }

    /**
     * 建造者模式
     */
    @Test
    @SneakyThrows
    public void testBuilder() {
        // 建造者
        final MacbookBuilder macbookBuilder = new MacbookBuilder();
        // 指挥者
        final Director director = new Director(macbookBuilder);
        // 封装构建过程
        director.construct("英特尔主板", "Retina显示器");
        // 构建产品，输出信息
        System.out.println("macbookBuilder = " + macbookBuilder.create());

        // 输出结果
        // macbookBuilder = Laptop(board=英特尔主板, display=Retina显示器, os=Mac OS x 10.10)
    }

    /**
     * 工厂方法模式
     */
    @Test
    @SneakyThrows
    public void testFactory() {
        // 创建工厂
        final FactoryA factoryA = new FactoryA();

        // 通过工厂生产产品
        final Product productA = factoryA.createProduct(ConcreteProductA.class);
        final Product productB = factoryA.createProduct(ConcreteProductB.class);

        productA.method();
        productB.method();

        // 结果输出
        // 具体产品A
        // 具体产品B
    }

    /**
     * 抽象工厂模式
     */
    @Test
    public void testAbstractFactory() {
        // 创建一个生产宝马汽车的工厂
        final BmwFactory bmwFactory = new BmwFactory();
        bmwFactory.createTire().tire();
        bmwFactory.createEngine().engine();

        System.out.println("------------------");

        // 创建一个生产吉利汽车的工厂
        final GeelyFactory geelyFactory = new GeelyFactory();
        geelyFactory.createTire().tire();
        geelyFactory.createEngine().engine();

        // 结果输出
        // 进口轮胎
        // 进口发送机
        // ------------------
        // 国产轮胎
        // 国产发送机
    }

}
