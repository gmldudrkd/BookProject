/*------------------------------------------------------------------------------
 * Name : SaveNoticeServlet
 * DESC : 사용자 로그인 시 사용되는 Controller 클래스
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
 *  공지사항 저장시 사용되는 서블릿 클래스
 * </pre>
 */
@WebServlet(name = "Save", urlPatterns = { "/save" })
public class SaveProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * servlet service 메소드. 
	 * 공지사항 정보를 저장하는클래스
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {
    	    request.setCharacterEncoding( "euc-kr" );

            // 구현 하시오
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
