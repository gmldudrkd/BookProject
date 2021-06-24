/*------------------------------------------------------------------------------
 * Name : LoginServlet
 * DESC : ����� �α��� �� ���Ǵ� Controller Ŭ����
 * VER  : 1.0
 *----------------------------------------------------------------------------*/

package product.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import product.biz.ProductBiz;
import product.entity.Product;



/**
 * <pre>
 *  ����� �α��� �� ���Ǵ� ���� Ŭ����
 * </pre>
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * servlet service �޼ҵ�. 
     * �ùٸ� �α������� Ȯ���ϰ� �����Ǹ� Session�� �����Ѵ�. �ش��ϴ� ȭ������ �����ش�.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

            request.setCharacterEncoding( "euc-kr" ); 
            //System.out.println("ok");

            // ���� �Ͻÿ�
            String id = request.getParameter("user");
            String pwd = request.getParameter("pass");
            
            ProductBiz biz = new ProductBiz();
            Product entity = biz.getLoginUser(id,pwd);
            
            if(entity != null){
    			/*���Ǽ���*/
            	System.out.println("ok");
    			HttpSession session=request.getSession();
    			session.setAttribute("logOK", entity ); //���Ǹ� : logOK , ���ǿ� dao���� ������ entity�� ��� ���� �α׾ƿ��ϱ� ������ ����ϵ�����
    			
    			response.sendRedirect("/product/result.jsp"); /*������ �������� �ʰ� �������� ��ȯ����*/
    		}else{
    			System.out.println("fail");
    			response.sendRedirect("/product/fail.html");
    		}

    }
}
