package com.devotion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String drivername = "com.mysql.cj.jdbc.Driver";
            Class.forName(drivername);
            // 数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/bighomework?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";

            Connection con = DriverManager.getConnection(url, "root", "123456");
            Statement statement = con.createStatement();
            PreparedStatement ps =con.prepareStatement("delete from Twibber where id =" +
                    request.getParameter("id"));
            ps.executeUpdate();


            response.sendRedirect("/big/Twibber");//todo:change later

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
    }
}
