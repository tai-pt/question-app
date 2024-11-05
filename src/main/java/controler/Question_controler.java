package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Question;
@WebServlet("/quiz")
public class Question_controler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List <Question> questions = new ArrayList<>();
		
		try {
Connection con = ConnectDB.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM login.questions");
			while (rs.next()) {
				questions.add(new Question(
						rs.getInt("id"),
						rs.getString("question"),
						rs.getString("option1"),
						rs.getString("option2"),
						rs.getString("option3"),
						rs.getString("option4"),
						rs.getInt("corret_option")
						));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println("Questions size: " + questions.size());
		req.setAttribute("questions", questions);
		req.getRequestDispatcher("quiz.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sc = 0;
	ArrayList <Question> question = (ArrayList<Question>) req.getAttribute("question");
	if (  question != null ) {
		for (Question questions : question ) {
			String awn = req.getParameter("awn" + questions.getId());
			if (awn != null ) {
				sc++;
			}
		}
	}
	req.setAttribute("sc", sc);
		req.getRequestDispatcher("rs.jsp").forward(req, resp);
	}
}
