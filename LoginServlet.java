/*------------------------------------------------------------------------------
 * Name : LoginServlet
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
 *  사용자 로그인 시 사용되는 서블릿 클래스
 * </pre>
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * servlet service 메소드. 
     * 올바른 로그인인지 확인하고 인증되면 Session을 생성한다. 해당하는 화면으로 보여준다.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

            request.setCharacterEncoding( "euc-kr" ); 
            //System.out.println("ok");

            // 구현 하시오
            String id = request.getParameter("user");
            String pwd = request.getParameter("pass");
            
            ProductBiz biz = new ProductBiz();
            Product entity = biz.getLoginUser(id,pwd);
            
            if(entity != null){
    			/*세션설정*/
            	System.out.println("ok");
    			HttpSession session=request.getSession();
    			session.setAttribute("logOK", entity ); //세션명 : logOK , 세션에 dao에서 가져온 entity를 담아 놓고 로그아웃하기 전까지 사용하도록함
    			
    			response.sendRedirect("/product/result.jsp"); /*내용을 가져가지 않고 페이지만 변환해줌*/
    		}else{
    			System.out.println("fail");
    			response.sendRedirect("/product/fail.html");
    		}

    }
}
