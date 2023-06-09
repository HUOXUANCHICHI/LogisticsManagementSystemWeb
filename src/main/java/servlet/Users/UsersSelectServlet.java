package servlet.Users;

import Factory.DaoFactory;
import lombok.extern.slf4j.Slf4j;
import model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
@Slf4j
@WebServlet(name = "UsersSelectServlet", value = "/UsersSelectServlet")
public class UsersSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        log.info("user select");
        try {
            List<Users> usersList = DaoFactory.usersDaoInstance().selectUsers();
            request.getSession().setAttribute("usersList", usersList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("users.jsp");
    }
}
