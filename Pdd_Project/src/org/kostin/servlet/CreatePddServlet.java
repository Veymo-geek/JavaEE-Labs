package org.kostin.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.kostin.beans.Pdd;
import org.kostin.utils.DBUtils;
import org.kostin.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createPdd" })
public class CreatePddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreatePddServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createPddView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String offence_id = (String) request.getParameter("offence_id");
        String model = (String) request.getParameter("model");
        String driver_name = (String) request.getParameter("driver_name");
        String offence_type = (String) request.getParameter("offence_type");
        String fineStr = (String) request.getParameter("fine");
        float fine = 0;
        try {
            fine = Float.parseFloat(fineStr);
        } catch (Exception e) {
        }
        Pdd pdd = new Pdd(offence_id, model, driver_name, offence_type, fine);
 
        String errorString = null;
 
        String regex = "\\w+";
 
        if (offence_id == null || !offence_id.matches(regex)) {
            errorString = "id invalid!";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertPdd(conn, pdd);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        request.setAttribute("errorString", errorString);
        request.setAttribute("pdd", pdd);
 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createPddView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/pddList");
        }
    }
 
}