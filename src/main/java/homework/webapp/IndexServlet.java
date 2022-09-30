package homework.webapp;

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
        Manufacturer[] manufacturers = ManufacturerControl.getAllManufacturers();
        Random random = new Random();
        assert manufacturers != null;
        Manufacturer manufacturer = manufacturers[random.nextInt(manufacturers.length)];

        int manufacturerId = manufacturer.getId();
        History[] histories = HistoryControl.getHistory(manufacturerId);
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
