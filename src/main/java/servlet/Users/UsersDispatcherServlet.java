package servlet.Users;

import dao.UsersDao;
import dao.impl.UsersImpl;
import lombok.extern.slf4j.Slf4j;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "UsersDispatcherServlet", value = "/UsersDispatcherServlet")
public class UsersDispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("user edit...");
        int userId = Integer.parseInt(request.getParameter("userId"));
        UsersDao usersDao = new UsersImpl();
        try {
            Users users = usersDao.selectUsersById(userId);
            request.getSession().setAttribute("users", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("users_update.jsp").forward(request, response);
    }
}
