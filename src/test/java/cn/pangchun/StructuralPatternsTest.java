package cn.pangchun;

import cn.pangchun.patterns.adapter.Volt220;
import cn.pangchun.patterns.adapter.VoltAdapter;
import cn.pangchun.patterns.adapter.VoltAdapter2;
import cn.pangchun.patterns.bridge.LargeCoffee;
import cn.pangchun.patterns.bridge.Ordinary;
import cn.pangchun.patterns.bridge.SmallCoffee;
import cn.pangchun.patterns.bridge.Sugar;
import cn.pangchun.patterns.composite.File;
import cn.pangchun.patterns.composite.Folder;
import cn.pangchun.patterns.decorator.Boy;
import cn.pangchun.patterns.decorator.CheapCloth;
import cn.pangchun.patterns.decorator.ExpensiveCloth;
import cn.pangchun.patterns.facade.MobilePhone;
import cn.pangchun.patterns.flyweight.Ticket;
import cn.pangchun.patterns.flyweight.TicketFactory;
import cn.pangchun.patterns.proxy.DynamicProxy;
import cn.pangchun.patterns.proxy.ILawsuit;
import cn.pangchun.patterns.proxy.Lawyer;
import cn.pangchun.patterns.proxy.Xiaomin;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

/**
 * 结构型设计模式-测试类
 *
 * @author pangchun
 * @since 2023/10/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
@Slf4j
public class StructuralPatternsTest {

    /**
     * 适配器模式: 类适配器
     */
    @Test
    public void testAdapter() {
        final VoltAdapter adapter = new VoltAdapter();
        System.out.println("输出电压：" + adapter.getVolt5());

        // 打印结果
        // 输出电压：5
    }

    /**
     * 适配器模式: 对象适配器
     */
    @Test
    public void testAdapter2() {
        final VoltAdapter2 adapter = new VoltAdapter2(new Volt220());
        System.out.println("输出电压：" + adapter.getVolt5());

        // 打印结果
        // 输出电压：5
    }

    /**
     * 桥接模式
     */
    @Test
    public void testBridge() {
        // 原味
        final Ordinary ordinary = new Ordinary();
        // 加糖
        final Sugar sugar = new Sugar();

        // 大杯原味
        final LargeCoffee largeOrdinary = new LargeCoffee(ordinary);
        // 大杯加糖
        final LargeCoffee largeSugar = new LargeCoffee(sugar);

        // 小杯原味
        final SmallCoffee smallOrdinary = new SmallCoffee(ordinary);
        // 小杯加糖
        final SmallCoffee smallSugar = new SmallCoffee(sugar);

        smallOrdinary.makeCoffee();

        // 打印结果
        // 小杯的原味咖啡
    }

    /**
     * 组合模式 - 文件树
     */
    @Test
    public void testComposite() {
        // 构造一个对象表示C盘根目录
        final Folder root = new Folder("C盘");

        // c盘下有一个文件 用户必看.txt
        root.addDir(new File("用户必看.txt"));

        // c盘下还有3个文件夹，分别是Windows、PerfLogs、Program File
        final Folder dirWin = new Folder("Windows");
        final Folder dirPer = new Folder("PerfLogs");
        final Folder dirPro = new Folder("Program File");

        root.addDir(dirWin);
        root.addDir(dirPer);
        root.addDir(dirPro);

        // Windows文件夹下有文件 explorer.exe
        dirWin.addDir(new File("explorer.exe"));

        // PerfLogs文件夹下有文件 null.txt
        dirPer.addDir(new File("null.txt"));

        // Program File文件夹下有文件夹 idea
        final Folder dirIdea = new Folder("idea");
        dirPro.addDir(dirIdea);
        // idea文件夹下有文件 test.java
        dirIdea.addDir(new File("test.java"));

        // 打印文件结构
        root.print();
    }

    /**
     * 装饰模式 - 人穿衣服
     */
    @Test
    public void testDecorator() {
        // 首先有一个男孩
        final Boy person = new Boy();

        // 穿一套便宜的衣服
        final CheapCloth cheapCloth = new CheapCloth(person);
        cheapCloth.dressed();

        System.out.println("-------------");

        // 穿一套昂贵的衣服
        final ExpensiveCloth expensiveCloth = new ExpensiveCloth(person);
        expensiveCloth.dressed();
    }

    /**
     * 外观模式 - 手机子系统
     */
    @Test
    public void testFacade() {
        final MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.takePicture();
        mobilePhone.videoChat();

        // 打印结果
        // 打开相机
        // 拍照
        // ---> 视频聊天接通中
        // 打开相机
        // 打电话
    }

    /**
     * 享元模式 - 火车票
     */
    @Test
    public void testFlyweight() {
        final Ticket ticket01 = TicketFactory.getTicket("北京", "青岛");
        ticket01.showTicketInfo("上铺");
        final Ticket ticket02 = TicketFactory.getTicket("北京", "青岛");
        ticket02.showTicketInfo("下铺");
        final Ticket ticket03 = TicketFactory.getTicket("北京", "青岛");
        ticket03.showTicketInfo("坐票");
    }

    /**
     * 代理模式：静态代理 - 律师诉讼
     */
    @Test
    public void testStaticProxy() {
        // 构造诉讼人小民
        final Xiaomin xiaomin = new Xiaomin();
        // 构造代理律师
        final Lawyer lawyer = new Lawyer(xiaomin);

        // 律师代理诉讼
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }

    /**
     * 代理模式：动态代理 - 律师诉讼
     */
    @Test
    public void testDynamicProxy() {
        // 构造诉讼人小民
        final Xiaomin xiaomin = new Xiaomin();

        // 构造一个动态代理类
        final DynamicProxy proxy = new DynamicProxy(xiaomin);

        // 获取被代理类小民的Classloader
        final ClassLoader classLoader = xiaomin.getClass().getClassLoader();

        // 动态构造一个代理律师
        final ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(classLoader, new Class[]{ILawsuit.class}, proxy);

        // 律师代理诉讼
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
