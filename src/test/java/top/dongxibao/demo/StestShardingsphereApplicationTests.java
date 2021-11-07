package top.dongxibao.demo;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dongxibao.demo.entity.Dict;
import top.dongxibao.demo.entity.Order;
import top.dongxibao.demo.entity.User;
import top.dongxibao.demo.mapper.DictMapper;
import top.dongxibao.demo.mapper.OrderMapper;
import top.dongxibao.demo.mapper.UserMapper;

import java.util.List;

@SpringBootTest
class StestShardingsphereApplicationTests {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DictMapper dictMapper;

    @Test
    void contextLoads() {
    }

    /**
     * 测试水平分库分表
     */
    @Test
    void testLevel() {
        for (int i = 0; i < 20; i++) {
            Order order = new Order();
            order.setUserId(RandomUtil.randomLong(10));
            order.setPrice(RandomUtil.randomBigDecimal());
            order.setStatus(RandomUtil.randomString(5));
            orderMapper.insert(order);
        }
    }

    /**
     * 测试垂直分库
     */
    @Test
    void testVertical() {
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setPhone(RandomUtil.randomString(11));
            user.setUserName("姓名" + i);
            userMapper.insert(user);
        }
    }

    /**
     * 测试公共表
     */
    @Test
    void testPublic() {
        for (int i = 0; i < 20; i++) {
            Dict dict = new Dict();
            dict.setDictType(RandomUtil.randomString(11));
            dict.setDictCode("code" + i);
            dict.setDictName(RandomUtil.randomString(11));
            dictMapper.insert(dict);
        }
    }

    /**
     * 测试读写分离
     */
    @Test
    void testWrite() {
        for (int i = 0; i < 2; i++) {
            Dict dict = new Dict();
            dict.setDictType(RandomUtil.randomString(11));
            dict.setDictCode("code" + i);
            dict.setDictName(RandomUtil.randomString(11));
            dictMapper.insert(dict);
            /**
             * 2021-11-07 17:11:45.401  INFO 11308 --- [           main] ShardingSphere-SQL                       : Rule Type: master-slave
             * 2021-11-07 17:11:45.402  INFO 11308 --- [           main] ShardingSphere-SQL                       : SQL: INSERT INTO t_dict  ( dict_type,
             * dict_code,
             * dict_name )  VALUES  ( ?,
             * ?,
             * ? ) ::: DataSources: m1
             * 2021-11-07 17:11:45.447  INFO 11308 --- [           main] ShardingSphere-SQL                       : Rule Type: master-slave
             * 2021-11-07 17:11:45.447  INFO 11308 --- [           main] ShardingSphere-SQL                       : SQL: INSERT INTO t_dict  ( dict_type,
             * dict_code,
             * dict_name )  VALUES  ( ?,
             * ?,
             * ? ) ::: DataSources: m1
             */
        }
    }


    /**
     * 测试读写分离
     */
    @Test
    void testRead() {
        List<Dict> dicts = dictMapper.selectList(null);
        System.out.println(dicts);
        /**
         * 2021-11-07 17:03:59.547  INFO 22392 --- [           main] ShardingSphere-SQL                       : Rule Type: master-slave
         * 2021-11-07 17:03:59.549  INFO 22392 --- [           main] ShardingSphere-SQL                       : SQL: SELECT  dict_id,dict_type,dict_code,dict_name  FROM t_dict ::: DataSources: s1
         */
    }
}
