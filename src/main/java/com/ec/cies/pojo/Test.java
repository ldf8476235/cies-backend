package com.ec.cies.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.StringListTypeHandler;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@TableName(value = "test",autoResultMap = true)
@Accessors(chain = true)
public class Test {

    private String name;

    @TableField(typeHandler = StringListTypeHandler.class)
    private List<String> type;


}
