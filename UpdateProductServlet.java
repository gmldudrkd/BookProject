package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.biz.ProductBiz;
import product.entity.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(name = "Update", urlPatterns = { "/update" })
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding( "euc-kr" );

		int num = Integer.parseInt(request.getParameter("num"));
        // 구현 하시오
        Product entity = new Product();
        entity.setDescription(request.getParameter("content"));
        entity.setNum(num);
        
        ProductBiz biz=new ProductBiz();
        int n=biz.productUpdate(entity);
        
       /* System.out.println(entity.getDescription());
        System.out.println(num);*/
        
		if(n>0){
			System.out.println("OK");
        	response.sendRedirect("/product/list");
		}else{
			System.out.println("Fail");
			response.sendRedirect("/product/list");

		}
	}

}
