package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserData;
import user.UserDataDAO;
import user.UserDataDTO;

/**
 * Servlet implementation class BuyComplete
 */
public class BuyComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyComplete() {
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
            ArrayList<productDataBeans> cart = (ArrayList<productDataBeans>) hs.getAttribute("Cart");
            /*
             * SQLに登録処理
             */
            UserData ud =(UserData)hs.getAttribute("ud");
            int num = (int) hs.getAttribute("totalPrice");
            ud.settotalPrice(num);
            UserDataDTO udd = new UserDataDTO();
            ud.UD2DTOMapping(udd);
            UserDataDAO.getInstance().updateTotal(udd);

            ud.setType(Integer.parseInt(request.getParameter("type")));
//            ArrayList<productDataBeans> userCart = (ArrayList)hs.getAttribute("userCart");

            for(int i = 0; i<cart.size(); i++) {
            	ud.setItemcode(cart.get(i).getCode());
            	ud.UD2DTOMapping(udd);
            	UserDataDAO.getInstance().boughtProduct(udd);
            }
            hs.removeAttribute("Cart");
//            hs.removeAttribute("userCart");
			request.getRequestDispatcher("/buyComplete.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
