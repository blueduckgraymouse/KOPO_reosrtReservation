<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="./notice_error.jsp" %>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시물 수정</title>
  <style>
    .container {
      max-width: 600px;
      margin:0 auto;
    }
    table {
      text-align: center;
    }
    td {
      border: 1px solid black;
    }
    .table-update {
      width: 600px;
      border-collapse: collapse;
    }
    .table-update td {
      height: 30px;
      border: 1px solid grey;
    }
    td.title {
      border-right: 3px double grey;
      background-color: #6791be;
    }
    .align-left {
      text-align: right;
    }
    a {
      color: black;
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
    textarea {
      width: 450px; 
      height: 250px;
    }
    div.div-button {
      text-align: right;
    }
    </style>
    <%
      int id = Integer.parseInt(request.getParameter("id"));
    
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopoctc", "root", "abcd1234");	
      
      String query = "select * from notice where id=?";
  
      PreparedStatement pstmt = conn.prepareStatement(query);
      
      pstmt.setInt(1, id);
  
      ResultSet rset = pstmt.executeQuery();
      rset.next();
    %>
</head>

<body>
  
  <div class="container">
    <h1>공지사항 수정</h1>

    <form method="post" action="notice_update.jsp">
      <table class="table-update">
        <tr>
          <td class="title"><b>번호</b></td>
          <td width="450px">
            <%= rset.getInt("id")%>
            <input type="hidden" name="id" value="<%= rset.getString("id")%>">
          </td>
        </tr>
        <tr>
          <td class="title"><b>제목</b></td>
          <td>
            <input type="text" name="title" size="62" maxlength="70" value="<%= rset.getString("title")%>">
          </td>
        </tr>
        <tr>
          <td class="title"><b>등록일</b></td>
          <td>
            <%= rset.getString("date")%>
            <input type="hidden" name="id" value="<%= rset.getString("date")%>">
          </td>
        </tr>
        <tr>
          <td class="title"><b>내용</b></td>
          <td>
            <textarea name="content" cols="70" row="600"><%= rset.getString("content")%></textarea>
          </td>
        </tr>
      </table>

      <br>

      <div class="div-button">
        <input type="submit" value="저장">
        <input type="button" value="삭제" onclick="location.href='notice_delete.jsp?id=<%= rset.getString("id")%>'">
        <input type="button" value="취소" onclick="history.go(-1)">
      </div>
    </form>
  </div>

  <%
    rset.close();
    pstmt.close();
    conn.close();
  %>
</body>

</html>