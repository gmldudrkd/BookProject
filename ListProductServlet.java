/*------------------------------------------------------------------------------
 * Name : ListNoticeServlet
 * DESC : 사용자 로그인 시 사용되는 Controller 클래스
 * VER  : 1.0
 *----------------------------------------------------------------------------*/

package product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import product.biz.ProductBiz;
import product.entity.Product;

/**
 * <pre>
 *  사용자 로그인 시 사용되는 서블릿 클래스
 * </pre>
 */
@WebServlet(name = "LIST", urlPatterns = { "/list" })
public class ListProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * servlet service 메소드. 
     * NoticeBiz 객체를 생성하여 공지사항 목록을 요청한다.
     * 전달받은 공지사항 목록을 list라는 이름으로 request 객체에 담는다.
     * notice/NoticeList.jsp 결과 페이지로 이동한다.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {
            request.setCharacterEncoding( "euc-kr" );
            // 구현 하시오
            ProductBiz biz=new ProductBiz();
    		
    		List<Product> list=biz.getProductList();
    		
    		if(list != null){
    			//System.out.println("ok");
    			/*request객체 - 주기만하고 빠진다*/
    			RequestDispatcher rd=request.getRequestDispatcher("product/productList.jsp");
    			request.setAttribute("listrs", list);/* request명 :list*/
    			rd.forward(request, response); //productList.jsp에게 위임
    			System.out.println("OK");
    		}else{
    			System.out.println("fail");
    		}
    }
}
