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

@MappedJdbcTypes(JdbcType.VARCHAR)  //数据库类型
@MappedTypes({List.class})
public class ListTypeHandler implements TypeHandler<List<String>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        String hobbys = dealListToOneStr(parameter);
        ps.setString(i , hobbys);
    }

    private String dealListToOneStr(List<String> parameter){
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
    public List<String> getResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.getString(columnName) == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(rs.getString(columnName).split(","));
    }

    @Override
    public List<String> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Arrays.asList(rs.getString(columnIndex).split(","));
    }

    @Override
    public List<String> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String hobbys = cs.getString(columnIndex);
        return Arrays.asList(hobbys.split(","));
    }
}
