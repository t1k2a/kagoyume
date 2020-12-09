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
 * Servlet implementation class Item
 */
public class Item extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item() {
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
            request.setCharacterEncoding("UTF-8");
			HttpSession hs = request.getSession();
        	ArrayList<productDataBeans> searchResult = (ArrayList<productDataBeans>) hs.getAttribute("searchResult");
			productDataBeans pdb = new productDataBeans();

        	if (request.getParameter("cartNum") != null) {
        		ArrayList<productDataBeans> cart = (ArrayList) hs.getAttribute("Cart");
        		pdb = cart.get(Integer.parseInt(request.getParameter("cartNum")));
        	} else {
            	int code = Integer.parseInt(request.getParameter("code"));
				pdb.setImage(searchResult.get(code).getImage());
				pdb.setCode(searchResult.get(code).getCode());
				pdb.setPrice(searchResult.get(code).getPrice());
				pdb.setProductName(searchResult.get(code).getProductName());
				pdb.setDescription(searchResult.get(code).getDescription());
				pdb.setReview(searchResult.get(code).getReview());
        	}

			hs.setAttribute("pdb", pdb);
			request.getRequestDispatcher("/item.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
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
