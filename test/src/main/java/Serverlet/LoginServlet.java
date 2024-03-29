package Serverlet;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform authentication logic using your DatabaseEngine and PointsOfInterestApp classes
        boolean isAuthenticated = PointsOfInterestApp.getInstance().authenticateUser(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("index.jsp"); // Redirect to the home page
        } else {
            // Handle authentication failure (e.g., show an error message)
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
