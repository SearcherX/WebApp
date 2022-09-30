package homework.webapp.servlets;

import homework.webapp.beans.History;
import homework.webapp.beans.Manufacturer;
import homework.webapp.beans.NewsHeader;
import homework.webapp.db.HistoryControl;
import homework.webapp.db.ManufacturerControl;
import homework.webapp.db.NewsHeaderControl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = {"/index",""})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получить список производителей
        Manufacturer[] manufacturers = ManufacturerControl.getAllManufacturers();
        //выбрать случайного производитея
        Random random = new Random();
        assert manufacturers != null;
        Manufacturer manufacturer = manufacturers[random.nextInt(manufacturers.length)];

        //получить Id выбраного производителя
        int manufacturerId = manufacturer.getId();
        //получить историю производителя
        History[] histories = HistoryControl.getHistory(manufacturerId);
        //получить список заголовков новостей производителя
        NewsHeader[] newsHeaders = NewsHeaderControl.getNewsHeaderByManufacturerId(manufacturerId);

        request.setAttribute("manufacturer", manufacturer);
        request.setAttribute("histories", histories);
        request.setAttribute("newsHeaders", newsHeaders);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
