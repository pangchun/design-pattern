package cn.pangchun;

import cn.pangchun.patterns.command.calculator.CalculatorInvoker;
import cn.pangchun.patterns.command.calculator.CalculatorMachine;
import cn.pangchun.patterns.command.calculator.command.impl.SettleCommand;
import cn.pangchun.patterns.command.calculator.command.impl.ZeroCommand;
import cn.pangchun.patterns.command.tetris.*;
import cn.pangchun.patterns.interpret.ArithmeticCalculator;
import cn.pangchun.patterns.iterator.ConcreteAggregate;
import cn.pangchun.patterns.iterator.Iterator;
import cn.pangchun.patterns.mediator.*;
import cn.pangchun.patterns.memoto.CallOfDuty;
import cn.pangchun.patterns.memoto.CareTaker;
import cn.pangchun.patterns.observer.Coder;
import cn.pangchun.patterns.observer.DevTechFrontier;
import cn.pangchun.patterns.responsibility.BillApplyHandlerChain;
import cn.pangchun.patterns.responsibility.handler.impl.CeoHandler;
import cn.pangchun.patterns.responsibility.handler.impl.FinanceHandler;
import cn.pangchun.patterns.responsibility.handler.impl.ManagerHandler;
import cn.pangchun.patterns.responsibility.request.BillApplyRequest;
import cn.pangchun.patterns.state.TvController;
import cn.pangchun.patterns.strategy.enums.FareTypeEnum;
import cn.pangchun.patterns.strategy.service.FareService;
import cn.pangchun.patterns.template.CoderComputer;
import cn.pangchun.patterns.template.MilitaryComputer;
import cn.pangchun.patterns.visitor.BusinessReport;
import cn.pangchun.patterns.visitor.CeoVisitor;
import cn.pangchun.patterns.visitor.CtoVisitor;
import com.google.common.collect.Maps;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 行为型设计模式-测试类
 *
 * @author pangchun
 * @since 2023/6/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
@Slf4j
public class BehavioralPatternsTest {

    @Resource
    private FareService fareService;

    /**
     * 策略模式
     */
    @Test
    @SneakyThrows
    public void testStrategy() {
         Map<FareTypeEnum, Integer> map = Maps.newHashMap();
         map.put(FareTypeEnum.BUS, 10);
         map.put(FareTypeEnum.SUBWAY, 10);
        for (Map.Entry<FareTypeEnum, Integer> entry : map.entrySet()) {
            FareTypeEnum type = entry.getKey();
            int distance = entry.getValue();
            int money = fareService.calculate(type, distance);
            log.info("乘坐{}，距离{}km，花费{}元", type.getName(), distance, money);
        }
    }

    /**
     * 责任链模式
     */
    @Test
    @SneakyThrows
    public void testResponsibility() {
        // 构造责任链
        final BillApplyHandlerChain chain = new BillApplyHandlerChain();
        chain.addHandler(new FinanceHandler());
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new CeoHandler());
        // 处理请求
        chain.process(new BillApplyRequest("Bob", new BigDecimal(100000)));
    }

    /**
     * 命令模式 - 俄罗斯方块
     */
    @Test
    public void testCommand1() {
        // 首先要有俄罗斯方块游戏
        final TetrisMachine tetrisMachine = new TetrisMachine();

        // 根据游戏我们构造四种命令
        final LeftCommand leftCommand = new LeftCommand(tetrisMachine);
        final RightCommand rightCommand = new RightCommand(tetrisMachine);
        final TransformCommand transformCommand = new TransformCommand(tetrisMachine);
        final FallCommand fallCommand = new FallCommand(tetrisMachine);

        // 按钮可以执行不同的命令
        final Buttons buttons = new Buttons();
        buttons.setLeftCommand(leftCommand)
                .setRightCommand(rightCommand)
                .setTransformCommand(transformCommand)
                .setFallCommand(fallCommand);

        // 具体按哪个按钮玩家说了算
        buttons.toLeft();
        buttons.toRight();
        buttons.transform();
        buttons.fall();
    }

    /**
     * 命令模式 - 计算器
     */
    @Test
    public void testCommand2() {
        // 首先有计算器
        final CalculatorMachine machine = new CalculatorMachine();

        // 构造结算和归零两个命令，其他命令需要结合数字按钮来构造，就直接放在CalculatorInvoker中，每次运算会先构造一个新的命令
        final SettleCommand settleCommand = new SettleCommand(machine);
        final ZeroCommand zeroCommand = new ZeroCommand(machine);

        // 计算器的按钮执行不同的命令
        final CalculatorInvoker invoker = new CalculatorInvoker();
        invoker.setMachine(machine)
                .setSettleCommand(settleCommand)
                .setZeroCommand(zeroCommand);

        // 由用户进行操作
        System.out.println("invoker.add(100) = " + invoker.add(100));
        System.out.println("invoker.add(200) = " + invoker.add(200));
        System.out.println("invoker.subtract(100) = " + invoker.subtract(100));
        System.out.println("invoker.divide(2) = " + invoker.divide(2));
        System.out.println("invoker.multiply(4) = " + invoker.multiply(4));
        if (invoker.canUndo()) {
            invoker.undo();
            System.out.println("invoker.settle() = " + invoker.settle());
        }
        System.out.println("invoker.divide(3) = " + invoker.divide(3));
        if (invoker.canUndo()) {
            invoker.undo();
            System.out.println("invoker.settle() = " + invoker.settle());
        }
        if (invoker.canRedo()) {
            invoker.redo();
            System.out.println("invoker.settle() = " + invoker.settle());
        }
    }

    /**
     * 解释器模式 - 计算器
     */
    @Test
    public void testInterpreter() {
        final ArithmeticCalculator calculator = new ArithmeticCalculator("1 + 22 + 333 + 4444");
        System.out.println("1 + 22 + 333 + 4444 = " + calculator.calculate());
    }

    /**
     * 迭代器模式 - 通用模式代码
     */
    @Test
    public void testIterator() {
        final ConcreteAggregate<String> list = new ConcreteAggregate<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        // 获取迭代器
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 中介者模式 - 主板
     */
    @Test
    public void testMediator() {
        // 构造主板对象
        final MainBoard mainBoard = new MainBoard();

        // 分别构造各个零件
        final CdDevice cdDevice = new CdDevice(mainBoard);
        final Cpu cpu = new Cpu(mainBoard);
        final GraphicsCard graphicsCard = new GraphicsCard(mainBoard);
        final SoundCard soundCard = new SoundCard(mainBoard);

        // 将各个零部件安装到主板
        mainBoard.setCdDevice(cdDevice)
                .setCpu(cpu)
                .setGraphicsCard(graphicsCard)
                .setSoundCard(soundCard);

        // 完成后就可以开始放片了
        cdDevice.load();
    }

    /**
     * 备忘录模式 - 使命召唤游戏
     */
    @Test
    public void testMemoto() {
        // 构造游戏对象
        final CallOfDuty game = new CallOfDuty();
        // 打游戏
        game.play();

        final CareTaker careTaker = new CareTaker();
        // 存档
        careTaker.archive(game.createMemoto());
        // 退出游戏
        game.quit();
        // 恢复游戏
        game.restore(careTaker.getMemoto());
    }

    /**
     * 观察者模式 - 技术网站发布订阅
     */
    @Test
    public void testObserver() {
        // 被观察的角色
        final DevTechFrontier devTechFrontier = new DevTechFrontier();
        // 观察者
        final Coder coder1 = new Coder("张三");
        final Coder coder2 = new Coder("李四");
        final Coder coder3 = new Coder("王五");

        // 订阅
        devTechFrontier.addObserver(coder1);
        devTechFrontier.addObserver(coder2);
        devTechFrontier.addObserver(coder3);

        // 发布
        devTechFrontier.postNewPublication("Linux内核最新消息");
    }

    /**
     * 状态模式 - 电视遥控器
     */
    @Test
    public void testState() {
        final TvController tvController = new TvController();
        // 设置开机状态
        tvController.powerOn();
        // 下一频道
        tvController.nextChannel();
        // 调高音量
        tvController.turnUp();
        // 上一频道
        tvController.prevChannel();
        // 调低音量
        tvController.turnDown();
        // 设置关机状态
        tvController.powerOff();
        // 调高音量，此时不会生效
        tvController.turnUp();
    }

    /**
     * 模板方法模式 - 电脑启动步骤
     */
    @Test
    public void testTemplate() {
        final CoderComputer coderComputer = new CoderComputer();
        final MilitaryComputer militaryComputer = new MilitaryComputer();

        coderComputer.startUp();
        militaryComputer.startUp();
    }

    /**
     * 访问者模式 - 员工报表
     */
    @Test
    public void testVisitor() {
        // 构建报表
        final BusinessReport report = new BusinessReport();
        // CEO访问者
        System.out.println("====这是给CEO看的报表=====");
        report.showReport(new CeoVisitor());
        // CTO访问者
        System.out.println("====这是给CTO看的报表=====");
        report.showReport(new CtoVisitor());
    }
}
