package com.akshay.tutorials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) {
        try {

            UserBean user = new UserBean();
            user.setUserName(request.getParameter("userId"));
            user.setPassword(request.getParameter("password"));

            //user = getDatabaseUser(user);
            user = getMockUser(user);

            if (user.isValid()) {

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                response.sendRedirect("success.jsp"); //logged-in page
            } else
                response.sendRedirect("fail.jsp"); //error page
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }

    private UserBean getMockUser(UserBean bean) {
        if ("akshay".equalsIgnoreCase(bean.getUsername())) {
            bean.setFirstName("Akshay");
            bean.setLastName("Anand");
            bean.setValid(true);
        }
        return bean;
    }

    private UserBean getDatabaseUser(UserBean bean) {
        return bean;
    }
}