<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.getRequestDispatcher("/BookServlet?method=findAll").forward(request, response); %>
