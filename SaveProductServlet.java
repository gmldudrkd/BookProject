/*------------------------------------------------------------------------------
 * Name : SaveNoticeServlet
 * DESC : ����� �α��� �� ���Ǵ� Controller Ŭ����
 * VER  : 1.0
 *----------------------------------------------------------------------------*/

package product.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import product.biz.ProductBiz;
import product.entity.Product;


/**
 * <pre>
 *  �������� ����� ���Ǵ� ���� Ŭ����
 * </pre>
 */
@WebServlet(name = "Save", urlPatterns = { "/save" })
public class SaveProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * servlet service �޼ҵ�. 
	 * �������� ������ �����ϴ�Ŭ����
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {
    	    request.setCharacterEncoding( "euc-kr" );

            // ���� �Ͻÿ�
            Product entity = new Product();
            entity.setWriter(request.getParameter("writer"));
            entity.setName(request.getParameter("title"));
            entity.setDescription(request.getParameter("content"));
            
            ProductBiz biz=new ProductBiz();
            int n=biz.productInsert(entity);
            
			if(n>0){
            	response.sendRedirect("/product/list");
    		}else{
    			response.sendRedirect("product/productInput.jsp");

    		}
    }
}
