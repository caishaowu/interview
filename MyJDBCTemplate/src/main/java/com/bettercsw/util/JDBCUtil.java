package com.bettercsw.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.Properties;

/**
 * @author csw
 * @date 2019/11/20 14:14
 */
public class JDBCUtil {
    // private Properties properties;
    private JDBCUtil() {
    }


    static {
        try {
            // todo NoClassDefFoundError
            // ClassLoader loader = Thread.currentThread().getContextClassLoader();
            // InputStream stream = loader.getResourceAsStream("db,properties");
            // properties = new Properties();
            // properties.load(stream);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("JDBC:mysql:///test", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void close(ResultSet rs, Connection conn, Statement st) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (st != null) {
                    try {
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
