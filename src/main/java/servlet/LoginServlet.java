package servlet;

import Factory.DaoFactory;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Users users = new Users();

        users.setUsername(request.getParameter("username"));
        users.setUserPwd(request.getParameter("userPwd"));

        users.setUserContact(request.getParameter("userContact"));
        try {
            if (DaoFactory.usersDaoInstance().login(users)) {
                users = DaoFactory.usersDaoInstance().selectUsersByName(request.getParameter("username"));
                request.getSession().setAttribute("users", users);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
