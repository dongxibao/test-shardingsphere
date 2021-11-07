package top.dongxibao.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Dongxibao
 * @date 2021/11/7
 */
@Data
@TableName("t_dict")
public class Dict {
    /** 主键 */
    private Long dictId ;
    /** 字典类型 */
    private String dictType ;
    /** 字典编码 */
    private String dictCode ;
    /** 字典名称 */
    private String dictName ;
}
