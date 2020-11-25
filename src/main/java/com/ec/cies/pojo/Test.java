package com.ec.cies.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.ListTypeHandler;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@TableName(value = "test",autoResultMap = true)
@Accessors(chain = true)
public class Test {

    private String name;

    @TableField(typeHandler = ListTypeHandler.class)
    private List<String> type;


}
