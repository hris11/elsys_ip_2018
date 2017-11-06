package org.elsys.ip.servlet.controller;

import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeUserServlet")
public class ChangeUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService data = new UserService();
        User oldUser = new User(Integer.valueOf(request.getParameter("oldUserId")),
                request.getParameter("oldUserName"),
                request.getParameter("oldUserEmail"));

        // Some crazy shiet

        int newUserid = 0;
        String newUserName = "";
        String newUserEmail = "";

        if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
            newUserid = oldUser.getId();
        } else {
            newUserid = Integer.valueOf(request.getParameter("id"));
        }
        if (request.getParameter("name") == null || request.getParameter("name").equals("")) {
            newUserName = oldUser.getName();
        } else {
            newUserName = request.getParameter("name");
        }
        if (request.getParameter("email") == null || request.getParameter("email").equals("")) {
            newUserEmail = oldUser.getEmail();
        } else {
            newUserEmail = request.getParameter("email");
        }


        User newUser = new User(newUserid, newUserName, newUserEmail);

        data.updateUser(oldUser, newUser);

        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
