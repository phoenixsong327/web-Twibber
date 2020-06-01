<%@ page import="java.util.List" %>
<%@ page import="com.devotion.Twibber" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 宋亚东
  Date: 2020/2/18
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%
    List<Twibber> lb=(List<Twibber>)request.getAttribute("twibber");
    String s = "";
    for (Twibber item :
            lb) {
      String minute;
      if(item.getMinute()>9)
        minute=""+item.getMinute();
      else
        minute="0"+item.getMinute();
      s+="<div class=\"border\" align=\"left\">" +
              "<div class=\"left\">" +
               "<img src=\"img/lappland.png\">" +
                "</div>" +
              "<div style=\"height:5px;width:80%\"></div>" +
              "<div class=\"time\">" +
              item.getHour()+":"+ minute +
              "</div>" +
              "<div class=\"content\">" +
              item.getContent()+
              "</div>" +
               "<div align=\"right\"><a  class =\"button\"  href=\"/devotion/Delete?id="+item.getId()+"\">删除</a></div>" +
              "</div>";
    }
  %>
  <html>
  <head>
    <title>Devotion</title>
  </head>
  <style>
    .left {
      float: left;
    }
    .left img{
      border-radius: 24px;
      width: 48px;
      height: 48px;
    }
    .border{
      background:#ffffffff;
      margin-top:50px;
      border-radius: 10px;
      opacity: 0.5;
    }
    .time{
      font-size:10px;
      width: 70%;
      margin-top: 10px;
      margin-left: 20px;
    }
    .content{
      margin-left: 20px;
      margin-bottom: 20px;
      width: 70%;
    }

    .button { /* 按钮美化 */
      width: 300px; /* 宽度 */
      height: 50px; /* 高度 */
      border-width: 0px; /* 边框宽度 */
      border-radius: 3px; /* 边框半径 */
      margin-right: 10px;
      background: red; /* 背景颜色 */
      cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
      outline: none; /* 不显示轮廓线 */
      font-family: Microsoft YaHei; /* 设置字体 */
      color: white; /* 字体颜色 */
      font-size: 15px; /* 字体大小 */
    }
    .button:hover { /* 鼠标移入按钮范围时改变颜色 */
      background: gray;
    }
    body{
        background:url("img/1569424034506.png")   ;
        background-repeat: no-repeat;
        background-size: 100%;
        background-attachment: fixed;
    }


  </style>

  <body>

  <form method="post" action="/devotion/Add">
    <div class="twibber_main" align="center">
      <div style="margin-top: 50px;width: 600px;background: cornsilk;height: 180px;opacity: 0.5;border-radius: 10px">
        <div align="left" style="margin-left: 10px" >
          分享新鲜事
        </div>
        <div style="margin-top: 5px">
          <textarea title="推博输入框" name="content" style="margin-bottom: 5px;border:solid 1px;resize: none;height: 100px;
          width: 580px;margin: 0px;overflow: hidden"></textarea>
        </div>
        <div align="right">
          <button type="submit" style="background: #1E90FF;border-radius: 3px;border-width: 0px;cursor: pointer;outline: none;font-family: 'Microsoft YaHei';
                    color: white;font-size: 17px;height: 30px;margin-top: 5px;margin-right: 10px">发送</button>
        </div>
      </div>
      <div style="width: 600px">
        <%=s%>
      </div>

    </div>
  </form>

  </body>
  </html>
