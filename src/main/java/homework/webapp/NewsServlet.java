package homework.webapp;

import homework.webapp.beans.NewsContent;
import homework.webapp.beans.NewsHeader;
import homework.webapp.db.NewsContentControl;
import homework.webapp.db.NewsHeaderControl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "NewsServlet", value = "/NewsServlet")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int selectId = Integer.parseInt(request.getParameter("selectId"));
        NewsHeader newsHeader = NewsHeaderControl.getNewsHeaderById(selectId);
        NewsContent[] newsContents = NewsContentControl.getNewsContent(selectId);

        request.setAttribute("newsHeader", newsHeader);
        request.setAttribute("newsContents", newsContents);

        getServletContext().getRequestDispatcher("/news.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
