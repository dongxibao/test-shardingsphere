package top.dongxibao.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Dongxibao
 * @date 2021/11/6
 */
@Data
@TableName("t_order")
public class Order {
    /** 订单id */
    private Long orderId ;
    /** 用户id */
    private Long userId ;
    /** 价格 */
    private BigDecimal price ;
    /** 订单状态 */
    private String status ;
}
