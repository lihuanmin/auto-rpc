import com.lee.rpc.consumer.AutoRpcConsumerApplication;
import com.lee.rpc.consumer.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * OrderControllerTest
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/16 11:47
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AutoRpcConsumerApplication.class)
public class OrderControllerTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void updateStock(){
        orderService.placeOrder();
    }
}
