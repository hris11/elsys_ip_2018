package org.elsys.ip.servlet.controller;

import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService data = new UserService();
        User oldUser = new User(Integer.valueOf(request.getParameter("oldUserId")),
                request.getParameter("oldUserName"),
                request.getParameter("oldUserEmail"));

        data.deleteUser(oldUser);

        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
