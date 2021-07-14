import com.bettercsw.unitTest.TicketException;
import com.bettercsw.unitTest.TicketSeller;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


/**
 * @author csw
 * @date 2020/1/9 15:55
 */
@DisplayName("售票器类型测试")
public class TicketSellerTest {
    //定义待测类的实例
    private TicketSeller ticketSeller;

    //定义在整个测试类开始前执行的操作
    //通常包括全局和外部资源（包括测试桩）的创建和初始化
    @BeforeAll
    public static void init() {

    }

    //定义在整个测试类完成后执行的操作
    //通常包括全局和外部资源的释放和销毁
    @AfterAll
    public static void cleanup() {

    }

    //定义在每个测试用例开始前执行的操作
    //通常包括基础数据和运行环境的准备
    @BeforeEach
    public void create() {
        ticketSeller = new TicketSeller();
    }

    //定义在每个测试用例完成后执行的操作
    //通常包括运行环境的清理
    @AfterEach
    public void destroy() {

    }

    //测试用例，当车票售出后余票应该减少
    @Test
    @Tag("fast")
    @DisplayName("售票后余票应该减少")
    public void shouldReduceInventoryWhenTicketSoldOut() throws TicketException {
        ticketSeller.setInventory(10);
        ticketSeller.sell(1);
        assertThat(ticketSeller.getInventory()).isEqualTo(9);
    }

    //测试用例，当余票不足时应该报错
    @Test
    @DisplayName("余票不足应报错")
    public void shouldThrowExceptionWhenNoEnoughInventory() {
        ticketSeller.setInventory(0);
        assertThatExceptionOfType(TicketException.class).isThrownBy(() -> {
            ticketSeller.sell(1);
        }).withMessageContaining("all ticket sold out").withNoCause();
    }

    @Test
    @Tag("slow")
    @DisplayName("一次性购买20张车票")
    public void shouldSuccessWhenBuy20TicketsOnce() {

    }

    //Disabled 注释将禁用测试用例
    //该测试用例会出现在最终的报告中，但不会被执行
    @Disabled
    @Test
    @DisplayName("有退票时余票应该增加")
    public void shouldIncreaseInventoryWhenTicketRefund() {
        ticketSeller.setInventory(10);
        ticketSeller.refund(1);
        assertThat(ticketSeller.getInventory()).isEqualTo(11);
    }


}
