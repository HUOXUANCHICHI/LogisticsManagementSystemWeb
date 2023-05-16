package servlet.Users;

import Factory.DaoFactory;
import model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersUpdateServlet", value = "/UsersUpdateServlet")
public class UsersUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Users users = new Users();
        users.setUserId(Integer.parseInt(request.getParameter("userId")));
        users.setUsername(request.getParameter("username"));
        users.setUserPwd(request.getParameter("userPwd"));
        users.setUserContact(request.getParameter("userContact"));
        users.setAccountRole(request.getParameter("accountRole"));
        try {
            if (DaoFactory.usersDaoInstance().updateUsers(users)) {
                request.getRequestDispatcher("UsersSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
