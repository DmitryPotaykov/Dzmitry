
package by.kursy.model.logic;

import javax.servlet.http.HttpServletRequest;


public class LogicService {
    public static String sum(HttpServletRequest request) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int c = a + b;
        
        request.setAttribute("result", c);
        
        return "resultSum.jsp";
    }
    
     public static String sub(HttpServletRequest request) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int c = a - b;
        
        request.setAttribute("result", c);
        
        return "resultSub.jsp";
    }
}
