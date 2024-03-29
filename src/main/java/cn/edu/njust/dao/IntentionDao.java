package cn.edu.njust.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.njust.bean.Intention;
import cn.edu.njust.bean.Student;
import cn.edu.njust.dao.*;
public class IntentionDao {

	public List<Intention> getAllintention(String stuID) throws SQLException {
		List<Intention> list = new ArrayList<Intention>();
    	String sql = "select stu_overview.stuID, stu_overview.name,intention from stu_overview join intention_list on stu_overview.stuID = intention_list.stuID where stu_overview.stuID = '" + stuID + "'";
    	Connection conn = DbUtil.getCon();   
        try {
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery();
             while(rs.next()) {
             	Intention itt = new Intention();
             	itt.setStuID(rs.getString("stuID"));
             	itt.setName(rs.getString("name"));
             	itt.setIntention(rs.getInt("intention"));
                list.add(itt);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return list;
    }
	//得到csp的所有intention
	public List<Intention> getAllintention() throws SQLException {
		List<Intention> list = new ArrayList<Intention>();
    	String sql = "select stu_overview.stuID, stu_overview.name,intention from stu_overview join intention_list on stu_overview.stuID = intention_list.stuID";
    	Connection conn = DbUtil.getCon();   
        try {
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery();
             while(rs.next()) {
             	Intention itt = new Intention();
             	itt.setStuID(rs.getString("stuID"));
             	itt.setName(rs.getString("name"));
             	itt.setIntention(rs.getInt("intention"));
                list.add(itt);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return list;
    }

	public Intention getSelectedintention(String stuID) throws SQLException {
        String sql = "select stuID, name, intention where stuID = '" + stuID + "'";
        Connection conn = DbUtil.getCon();
        Intention itt = new Intention();
        try {
        	PreparedStatement pst = conn.prepareStatement(sql);
        	ResultSet rs = pst.executeQuery();
        	while(rs.next()) {
        		itt.setStuID(rs.getString("stuID"));
             	itt.setName(rs.getString("name"));
             	itt.setIntention(rs.getInt("intention"));
        	}
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return itt;
    }

    public boolean modifyintentionInfo(String stuID, String name, int intention) throws SQLException {
    	String sql = "update intention_list set name = ? where stuID = " + stuID + "";
    	Connection conn = DbUtil.getCon();
    	try {			
    		PreparedStatement pst = conn.prepareStatement(sql);
    		pst.setString(1, name);
    		int flag = pst.executeUpdate();
    		pst.close();
    		return flag > 0 ? true : false;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
	}

	//删除没想好咋做
	public boolean deleteintention(String stuID) throws SQLException {
    	String sql = "delete from intention_list where stuID = '" + stuID + "'";
    	Connection conn = DbUtil.getCon();
    	try {
    		PreparedStatement pst = conn.prepareStatement(sql);
    		int flag = pst.executeUpdate();
    		pst.close();
    		return flag > 0 ? true : false;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
	
	//通过学号添加Intention表
	/*	public boolean addIntention(String stuid) throws SQLException {
	    	String sql = "insert into intention_list(stuID, name, intention) values (?, ?, ?)";
	    	Connection conn = DbUtil.getCon();
	    	try {
	    		StudentDao dao = new StudentDao();
	    		Student stu = dao.getInfo(stuid);
	    		PreparedStatement pst = conn.prepareStatement(sql);
	    		pst.setString(1, stu.getStuID());
	    		pst.setString(2, stu.getStuName());
	    		pst.setString(3, stu.getStuPersonID());
	    		int flag = pst.executeUpdate();
	    		pst.close();
	    		return flag > 0 ? true : false;
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    		return false;
	    	}
	    }
	*/
}
