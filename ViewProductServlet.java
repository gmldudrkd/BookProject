/*------------------------------------------------------------------------------
 * Name : ViewNoticeServlet
 * DESC : 사용자 로그인 시 사용되는 Controller 클래스
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
 *  공지사항 상세 조회에 사용되는 서블릿 클래스
 * </pre>
 */
@WebServlet(name = "VIEW", urlPatterns = { "/view" })
public class ViewProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * servlet service 메소드. 
     * 특정 공지사항 번호를 입력받아 공지사항 내용을 보여준다.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

    	    request.setCharacterEncoding( "euc-kr" );

            // 구현 하시오
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
