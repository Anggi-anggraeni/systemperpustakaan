package projectperpus.aplikasi.systemperpustakaan.utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtility {
    Connection connection;
    Date curDate;
    Date nextYearDate;
    Date beginOfMonthDate;
    Date endOfMonthDate;

    public DateUtility() {
        connection = new DbUtility().getConnection();
        getAnyVariableDate();
    }

    public Date getBeginOfMonthDate() {
        return beginOfMonthDate;
    }

    public Date getCurDate() {
        return curDate;
    }

    public Date getEndOfMonthDate() {
        return endOfMonthDate;
    }

    public Date getNextYearDate() {
        return nextYearDate;
    }

    protected final void getAnyVariableDate(){
        ResultSet rs;
        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT CURDATE()");if(rs.next()) curDate = rs.getDate(1);
            rs = st.executeQuery("SELECT DATE_ADD(CURDATE(), INTERVAL 1 YEAR)");if(rs.next()) nextYearDate = rs.getDate(1);
            rs = st.executeQuery("SELECT DATE_SUB(CURDATE(), INTERVAL DAYOFMONTH(CURDATE())-1 DAY)");if(rs.next()) beginOfMonthDate = rs.getDate(1);
            rs = st.executeQuery("SELECT LAST_DAY(CURDATE())");if(rs.next()) endOfMonthDate = rs.getDate(1);
        } catch (Exception e) { }
    }
    
    public Date createDate(String tgl){
        PreparedStatement st = null;Date d = null;
        try {
            st = connection.prepareStatement("SELECT Date(?)"); st.setString(1, tgl);
            ResultSet rs = st.executeQuery();
            if(rs.next()) d = rs.getDate(1); else return null;
        } catch (Exception e) {} return d;
    }

    public  boolean isDateValid(String dt) {
	String dateformat = "yyyy-MM-dd";
        if(dt.length() > 10) return false;
	java.util.Date dt1;
	try {
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		sdf.setLenient(false);
		dt1 = sdf.parse(dt);
//                System.out.println("Date: "+dt+" valid ");
                return true;
	} catch (ParseException e) {
//                System.out.println(e.getMessage());
//                System.out.println("Date: "+dt+ "  not valid");
                 return false;
	} catch (IllegalArgumentException e) {
//                System.out.println("Date: "+dt+ "  not valid");
                return false;
        }
    }

    public int getDiffrentDate(Date date1, Date date2){
        PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT DATEDIFF(?,?);");
            st.setDate(1, date1);st.setDate(2, date2);
            ResultSet rs = st.executeQuery();
            if(rs.next()) return rs.getInt(1);
        } catch (Exception e) { }
        return 0;
    }

}
