/*------------------------------------------------------------------------------
 * Name : ViewNoticeServlet
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
 *  �������� �� ��ȸ�� ���Ǵ� ���� Ŭ����
 * </pre>
 */
@WebServlet(name = "VIEW", urlPatterns = { "/view" })
public class ViewProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * servlet service �޼ҵ�. 
     * Ư�� �������� ��ȣ�� �Է¹޾� �������� ������ �����ش�.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

    	    request.setCharacterEncoding( "euc-kr" );

            // ���� �Ͻÿ�
    	    String name = request.getParameter("name");
    	    ProductBiz biz=new ProductBiz();
    	    Product entity = biz.productView(name);
    	    
    	    if(entity != null){
    	    	RequestDispatcher rd=request.getRequestDispatcher("product/productView.jsp");
    			request.setAttribute("view", entity);
    			rd.forward(request, response);
    	    }else{
    			System.out.println("fail");
    		}
        
    }
}
