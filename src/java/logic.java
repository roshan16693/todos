
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
@WebServlet(urlPatterns = {"/add"})
public class logic extends HttpServlet {
    static  int i=1;
     Map<Integer,String> map=new HashMap<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String todoThing=request.getParameter("todo");
        map.put(i, todoThing);
        ++i;
        HttpSession session=request.getSession(true);
        session.setAttribute("items", map); 
        //request.setAttribute("items", map); 
        RequestDispatcher dis=this.getServletContext().getRequestDispatcher("/delete");
        //System.out.println(dis);
        dis.forward(request, response);
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        request.getRequestDispatcher("/delete.java").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request, response);
   }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

