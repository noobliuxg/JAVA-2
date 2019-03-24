package cn.com.java.thread.lock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUtils {

    private final static String UPDATE_SQL_VERSION = "UPDATE GOODS SET STATUS=?,VERSION=VERSION+1 WHERE VERSION=? AND ID=?";
    private final static String UPDATE_SQL_TIME = "UPDATE GOODS SET STATUS=?,TIME_UNIT=? WHERE TIME_UNIT=? AND ID=?";
    private final static String UPDATE_SQL = "UPDATE GOODS SET STATUS=? WHERE ID=?";
    private final static String SELECT_SQL = "SELECT ID,STATUS,VERSION,TIME_UNIT FROM GOODS WHERE ID=?";


    public static synchronized int updatePes(Goods goods){
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(UPDATE_SQL);
            ps.setInt(1,goods.getStatus());
            ps.setInt(2,goods.getId());
            int result = ps.executeUpdate();
            connection.commit();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.clean(ps);
            JdbcUtils.clean(connection);
        }
        return -1;
    }

    public static int updateOptByVersion(Goods goods){
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(UPDATE_SQL_VERSION);
            ps.setInt(1,goods.getStatus());
            ps.setInt(2,goods.getVersion());
            ps.setInt(3,goods.getId());
            int result = ps.executeUpdate();
            connection.commit();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.clean(ps);
            JdbcUtils.clean(connection);
        }
        return -1;
    }

    public static int updateOptByTimestamp(Goods goods){
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(UPDATE_SQL_TIME);
            ps.setLong(2,System.currentTimeMillis());
            ps.setInt(1,goods.getStatus());
            ps.setInt(4,goods.getId());
            ps.setLong(3,goods.getTimeUnit());
            int result = ps.executeUpdate();
            connection.commit();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.clean(ps);
            JdbcUtils.clean(connection);
        }
        return -1;
    }

    public static Goods select(int id){
        PreparedStatement ps = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(SELECT_SQL);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                Goods goods = new Goods();
                goods.setId(rs.getInt(1));
                goods.setStatus(rs.getInt(2));
                goods.setVersion(rs.getInt(3));
                goods.setTimeUnit(rs.getLong(4));
                return goods;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.clean(rs);
            JdbcUtils.clean(ps);
            JdbcUtils.clean(connection);
        }
        return null;
    }
}
