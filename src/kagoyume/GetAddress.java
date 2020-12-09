package kagoyume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetAddress
 */
public class GetAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String zipcode = request.getParameter("zipcode");
			String url = "https://zip-cloud.appspot.com/api/search?zipcode=" + zipcode;
			URL con_url = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)con_url.openConnection();
			conn.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String json = "";
			String receiver = "";
			while ((receiver = br.readLine()) != null) {
				json += receiver;
			}
			br.close();

			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			String search_zipcode = root.get("results").get(0).get("zipcode").textValue();
			String address1 = root.get("results").get(0).get("address1").textValue();
			String address2 = root.get("results").get(0).get("address2").textValue();
			String address3 = root.get("results").get(0).get("address3").textValue();

			request.setAttribute("search_zipcode", search_zipcode);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
			request.setAttribute("address3", address3);

			request.getRequestDispatcher("/WEB-INF/getAddress.jsp").forward(request, response);
		}catch(IOException e) {
			System.out.print(e);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
