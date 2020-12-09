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

/**
 * Servlet implementation class Add
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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

			productDataBeans pdb = (productDataBeans)hs.getAttribute("item");
			ArrayList<productDataBeans> cart = new ArrayList<productDataBeans>();

			if (!request.getHeader("REFERER").contains("Cart")) { // 重複防止

				if (hs.getAttribute("Cart") != null) {
					cart = (ArrayList<productDataBeans>)hs.getAttribute("Cart");
				}

				UserData ud = new UserData();
				cart.add(pdb);
				hs.setAttribute("Cart", cart); // カート情報をセッションに格納

				request.setAttribute("Code", pdb.getCode()); // 画面表示用リクエストパラメータ
			}

			request.getRequestDispatcher("/add.jsp").forward(request, response);
		}catch(ServletException e) {
			System.out.println(e.getStackTrace());
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
