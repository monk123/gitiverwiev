package by.ayupov;

import by.ayupov.entity.Price;
import by.ayupov.entity.Product;
import by.ayupov.services.impl.PriceServiceImpl;
import by.ayupov.services.impl.ProductsServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ProductsServiceImpl<Product> productsService = new ProductsServiceImpl<>();
        List<Product> list = productsService.getProductsOnPage(1 ,5);

        request.setAttribute("list", list);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
