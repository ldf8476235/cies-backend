package com.ec.cies.utils.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@MappedJdbcTypes(JdbcType.VARCHAR)  //数据库类型
@MappedTypes({List.class})
public class LongListTypeHandler implements TypeHandler<List<Long>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<Long> longs, JdbcType jdbcType) throws SQLException {
        String hobbys = dealListToOneStr(longs);
        ps.setString(i , hobbys);
    }

    private String dealListToOneStr(List<Long> parameter){
        if(parameter == null || parameter.size() <=0)
            return null;
        String res = "";
        for (int i = 0 ;i < parameter.size(); i++) {
            if(i == parameter.size()-1){
                res+=parameter.get(i);
                return res;
            }
            res+=parameter.get(i)+",";
        }
        return null;
    }

    @Override
    public List<Long> getResult(ResultSet resultSet, String s) throws SQLException {
        String[] idArray = resultSet.getString(s).split(",");
        return Arrays.stream(idArray)
                .map(s1 ->Long.parseLong(s1.trim())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public List<Long> getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
