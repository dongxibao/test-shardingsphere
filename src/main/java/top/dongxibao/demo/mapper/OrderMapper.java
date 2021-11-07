package top.dongxibao.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.dongxibao.demo.entity.Order;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
