/*------------------------------------------------------------------------------
 * Name : LogoutServlet
 * DESC : 사용자 로그 아웃시 사용되는 Controller 클래스
 * VER  : 1.0
 *----------------------------------------------------------------------------*/

package product.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import product.entity.Product;

import java.io.*;

/**
 * <pre>
 *  사용자 로그아웃 시 사용되는 서블릿 클래스
 * </pre>
 * 
 */
@WebServlet(name = "Logout", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * servlet service 메소드. 
     * 현재 사용하는 session을 invalidate 한다. index.html 화면으로 보여준다.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

    		HttpSession session=request.getSession();
    		Product entity=(Product)session.getAttribute("logOK"); /*세션에 접속*/
		
    		if(entity!= null){
			//session.removeAttribute("logOK"); //logOK세션만 종료
			
			session.invalidate(); //모든 세션을 종료
			response.sendRedirect("/product/login.jsp");
    		}
        
    }
 }
