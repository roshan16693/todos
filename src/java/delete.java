

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/delete"})
public class delete extends HttpServlet {

    static Integer i;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession(false);
         Map<Integer,String> mapy=(HashMap<Integer, String>)session.getAttribute("items");
     String ids=request.getParameter("id");
         if(ids!=null)
         {
              i=Integer.parseInt(ids);
         }
         mapy.remove(i);
          session.setAttribute("itemy", mapy);
         System.out.println(mapy);
           RequestDispatcher dis=this.getServletContext().getRequestDispatcher("/display");
        //System.out.println(dis);
        dis.forward(request, response);
         
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        String ids=request.getParameter("id");
//        int id=Integer.parseInt(ids);
//         Map<Integer,String> maps=(Map<Integer,String>)request.getAttribute("items");
//         System.out.println(maps);
//        maps.remove(id);
//         System.out.println(maps);
//        request.setAttribute("item", maps);
//        request.getRequestDispatcher("./index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
