package top.dongxibao.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Dongxibao
 * @date 2021/11/6
 */
@Data
@TableName("t_user")
public class User {
    /** 用户id */
    private Long userId ;
    /** 用户名 */
    private String userName ;
    /** 手机号 */
    private String phone ;
}
