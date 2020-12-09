package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		try(PrintWriter out = response.getWriter()){

			HttpSession hs = request.getSession();
			ArrayList<productDataBeans> cart = (ArrayList<productDataBeans>)hs.getAttribute("Cart");
			String URL = "/cart.jsp";

			if (request.getParameter("delete") != null) {
				cart.remove(Integer.parseInt(request.getParameter("delete")));
			}

			if (hs.getAttribute("ud") == null) {
				request.setAttribute("message", "カートを見るにはログインしてください");
				URL = "Login";
			}

			request.getRequestDispatcher(URL).forward(request, response);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
