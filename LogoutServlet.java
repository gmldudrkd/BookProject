/*------------------------------------------------------------------------------
 * Name : LogoutServlet
 * DESC : ����� �α� �ƿ��� ���Ǵ� Controller Ŭ����
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
 *  ����� �α׾ƿ� �� ���Ǵ� ���� Ŭ����
 * </pre>
 * 
 */
@WebServlet(name = "Logout", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * servlet service �޼ҵ�. 
     * ���� ����ϴ� session�� invalidate �Ѵ�. index.html ȭ������ �����ش�.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

    		HttpSession session=request.getSession();
    		Product entity=(Product)session.getAttribute("logOK"); /*���ǿ� ����*/
		
    		if(entity!= null){
			//session.removeAttribute("logOK"); //logOK���Ǹ� ����
			
			session.invalidate(); //��� ������ ����
			response.sendRedirect("/product/login.jsp");
    		}
        
    }
 }
