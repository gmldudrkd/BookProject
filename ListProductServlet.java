/*------------------------------------------------------------------------------
 * Name : ListNoticeServlet
 * DESC : ����� �α��� �� ���Ǵ� Controller Ŭ����
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
 *  ����� �α��� �� ���Ǵ� ���� Ŭ����
 * </pre>
 */
@WebServlet(name = "LIST", urlPatterns = { "/list" })
public class ListProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * servlet service �޼ҵ�. 
     * NoticeBiz ��ü�� �����Ͽ� �������� ����� ��û�Ѵ�.
     * ���޹��� �������� ����� list��� �̸����� request ��ü�� ��´�.
     * notice/NoticeList.jsp ��� �������� �̵��Ѵ�.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {
            request.setCharacterEncoding( "euc-kr" );
            // ���� �Ͻÿ�
            ProductBiz biz=new ProductBiz();
    		
    		List<Product> list=biz.getProductList();
    		
    		if(list != null){
    			//System.out.println("ok");
    			/*request��ü - �ֱ⸸�ϰ� ������*/
    			RequestDispatcher rd=request.getRequestDispatcher("product/productList.jsp");
    			request.setAttribute("listrs", list);/* request�� :list*/
    			rd.forward(request, response); //productList.jsp���� ����
    			System.out.println("OK");
    		}else{
    			System.out.println("fail");
    		}
    }
}
