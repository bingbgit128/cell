package com.d3.cell.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;

public class BlobTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        //声明一个输入流对象
        ByteArrayInputStream bis;
        try {
            //把字符串转为字节流
            bis = new ByteArrayInputStream(s.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }
        preparedStatement.setBinaryStream(i, bis, s.length());

    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Blob blob = (Blob) resultSet.getBlob(s);
        byte[] returnValue = null;
        if (null != blob) {
            returnValue = blob.getBytes(1, (int) blob.length());
        }
        try {
            //将取出的流对象转为utf-8的字符串对象
            return new String(returnValue, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }

    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Blob blob = resultSet.getBlob(i);
        byte[] returnValue = null;
        String result = null;
        if (null != blob) {
            returnValue = blob.getBytes(1L, (int) blob.length());
        }
        try {
            if (returnValue != null) {
                result = new String(returnValue, "utf-8");
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int i) throws SQLException {
        Blob blob = cs.getBlob(i);
        byte[] returnValue = null;
        String result = null;
        if (null != blob) {
            returnValue = blob.getBytes(1L, (int) blob.length());
        }
        try {
            if (returnValue != null) {
                result = new String(returnValue, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


}
