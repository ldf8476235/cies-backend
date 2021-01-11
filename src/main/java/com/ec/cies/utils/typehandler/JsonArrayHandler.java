package com.ec.cies.utils.typehandler;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonObject;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)  //数据库类型
@MappedTypes({JSONArray.class})
public class JsonArrayHandler implements TypeHandler<JSONArray> {


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, JSONArray objects, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i , objects.toString());
    }

    @Override
    public JSONArray getResult(ResultSet resultSet, String s) throws SQLException {
        return JSONArray.parseArray(resultSet.getString(s));
    }

    @Override
    public JSONArray getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public JSONArray getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
