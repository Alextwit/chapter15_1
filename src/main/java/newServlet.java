import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cool-Servlet")
public class newServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF8");
        PrintWriter out = resp.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title>Задание №1</title>");
            out.println("<meta charset=utf - 8/>");
            out.println("</head>");
            out.println("<body>");
            out.print("<p><b>Генерация таблиц по переданным параметрам: заголовок, количество строк и столбцов, цвет фона.</b></p>");

            out.print("<p>Введите заголовок:</p>");
            out.println("<input type=text name=word>");

            out.print("<p>Введите количество строк:</p>");
            out.println("<input type=text name=row>");

            out.print("<p>Введите количество столбцов</p>");
            out.println("<input type=text name=column>");

            out.print("<p>Введите цвет фона:</p>");
            out.println("<input type=text name=bgcolor>");
            out.println("<input type=submit>");
            out.println("</form>");

            String word = req.getParameter("word");
            String row = req.getParameter("row");
            String column = req.getParameter("column");
            String bgcolor = req.getParameter("bgcolor");

            //Заголовок
            out.println("<center><h1>" + word + "</center></h1>");

            //Таблица
            out.println("<table bgcolor=" + bgcolor + ">");

            for (int i = 0; i < Integer.parseInt(row); i++) {
                out.println("<tr>");
                for (int j = 0; j < Integer.parseInt(column); j++) {
                    out.println("<td>");
                    out.println("Строка:" + (i + 1) + "Ячейка" + (j + 1));
                    out.println("</td>");
                }
                out.println("</tr>");
            }

            out.println("</table>");


            out.println("</body></html>");
        } finally {
            out.close();
        }

    }
}
