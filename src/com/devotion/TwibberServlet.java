package com.devotion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet(name = "TwibberServlet")
public class TwibberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String drivername = "com.mysql.cj.jdbc.Driver";
            Class.forName(drivername);
            // 数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/SongYadong?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";

            Connection con = DriverManager.getConnection(url, "root", "990325");
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * from Twibber");
            //authorid = "1";

            List<Twibber> list = new ArrayList<>();
            while(rs.next())
            {
                list.add(new Twibber(Integer.parseInt(rs.getString("id")),Integer.parseInt(rs.getString("publisherId")),
                        rs.getString("content"),Integer.parseInt(rs.getString("year")),
                        Integer.parseInt(rs.getString("month")),Integer.parseInt(rs.getString("day")),
                        Integer.parseInt(rs.getString("hour")),Integer.parseInt(rs.getString("minute"))));

            }
            Collections.reverse(list);
            request.setAttribute("twibber",list);
            request.getRequestDispatcher("/index.jsp").forward(request,
                    response);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
    }

}
