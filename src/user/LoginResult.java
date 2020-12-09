package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginResult
 */
public class LoginResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
            request.setCharacterEncoding("UTF-8");
            HttpSession hs = request.getSession();
//
//			if(!request.getHeader("REFERER").contains("Registration")) {
//                throw new Exception("不正なアクセスです");
//			}

			UserData ud = new UserData();
			ud.setName(request.getParameter("name"));
            ud.setPassword(request.getParameter("password"));

            UserDataDTO udd = new UserDataDTO();
            ud.UD2DTOMapping(udd); // この段階ではnameとpasswordしか入っていない

            UserDataDAO dao = new UserDataDAO();
            ArrayList<UserDataDTO> udList = dao.forLogin(udd);

            String loginStatus = "";
            String URL = ((String) hs.getAttribute("referer")).substring(31);

            if(udList.size() == 0) {
            	loginStatus = "ユーザーが見つかりませんでした";
            }else{
	            for(int i=0; i<udList.size(); i++) {
	            	loginStatus = "ログインしました！";
	                hs.setAttribute("ud", ud);
	                UserDataDTO udt = udList.get(i);
                    ud.DTO2UDMapping(udt); // 改めてユーザー情報を入れる

	            	if(ud.getDeleteFlg() == 1) {
	            		loginStatus = "削除されたユーザーです";
	        			response.sendRedirect(URL);
	            	}
	            }
	       }

            hs.setAttribute("loginStatus", loginStatus);
			response.sendRedirect(URL);
		} catch (Exception e) {
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
