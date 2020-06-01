package com.devotion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String drivername = "com.mysql.cj.jdbc.Driver";
            Class.forName(drivername);
            // 数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/SongYadong?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";

            Connection con = DriverManager.getConnection(url, "root", "990325");
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * from Twibber");
            int i=0;
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString("id"));
            }
            i++;
            PreparedStatement ps =con.prepareStatement("insert into Twibber(id,publisherId,content,year,month,day,hour,minute)" +
                    " values(?,?,?,?,?,?,?,?)");
            ps.setString(1,""+i);
            ps.setString(2,"1");
            ps.setString(3,request.getParameter("content"));
            Calendar calendar=Calendar.getInstance();
            ps.setString(4,""+calendar.get(Calendar.YEAR));
            ps.setString(5,""+calendar.get(Calendar.MONTH));
            ps.setString(6,""+calendar.get(Calendar.DAY_OF_MONTH));
            ps.setString(7,""+calendar.get(Calendar.HOUR_OF_DAY));
            ps.setString(8,""+calendar.get(Calendar.MINUTE));
            ps.executeUpdate();

            response.sendRedirect("/devotion/Twibber");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
