package servlet.Users;

import Factory.DaoFactory;
import lombok.extern.slf4j.Slf4j;
import model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@Slf4j
@WebServlet(name = "UserInsertServlet", value = "/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("user insert...");
        Users users = new Users();
        users.setUsername(request.getParameter("username"));
        users.setUserPwd(request.getParameter("userPwd"));
        users.setUserContact(request.getParameter("userContact"));
        try {
            if (DaoFactory.usersDaoInstance().insertUsers(users)) {
                request.getRequestDispatcher("UsersSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
