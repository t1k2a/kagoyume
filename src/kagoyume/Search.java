package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;

import base.Common;
import base.Helper;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
        	String name = request.getParameter("name"); //検索した文字列
        	Common common = new Common();
            String appID = common.getAppID();
            //検索未入力判定
            if(name != ""){
            	String encName = URLEncoder.encode(name, "UTF-8");
            	//クエリストリングでURL生成
            	String requesturl = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid="
                					+ appID + "&query=" + encName;
                JsonNode str = JSON_Mapping.getResult(requesturl); //生成されたURLのサイトから文字列を取得する
                HttpSession hs = request.getSession();
                int totalResult = Integer.parseInt(String.valueOf(str.get("ResultSet").get("totalResultsAvailable").textValue()));
                Helper helper = new Helper();

                ArrayList<productDataBeans> searchResult = new ArrayList<>();
                for(int i=0; i<=10; i++) { // 上位10件のみのため
                	productDataBeans pdb = new productDataBeans();
                	pdb.setImage(helper.getImage(str, i));
                	pdb.setCode(helper.getCode(str, i));
                	pdb.setProductName(helper.getName(str, i));
                	pdb.setPrice(helper.getPrice(str, i));
                	pdb.setReview(helper.getReview(str, i));
                	pdb.setDescription(helper.getDescription(str, i));
                	searchResult.add(pdb);
                }

                request.setAttribute("totalResult", totalResult);
                hs.setAttribute("searchResult", searchResult);

                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
