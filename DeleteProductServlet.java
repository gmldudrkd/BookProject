package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.biz.ProductBiz;
import product.entity.Product;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "euc-kr" );

        // ���� �Ͻÿ�
		int num = Integer.parseInt(request.getParameter("num"));
        Product entity = new Product();
        entity.setNum(num);
        
        ProductBiz biz=new ProductBiz();
        int n=biz.productDelete(entity);
        
		if(n>0){
        	response.sendRedirect("/product/list");
		}else{
			System.out.println("���� �� ������ �߻��Ͽ����ϴ�.");
			response.sendRedirect("/product/list");
		}
	}

}
