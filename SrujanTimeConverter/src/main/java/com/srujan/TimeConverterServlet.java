package com.srujan;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TimeConverterServlet")
public class TimeConverterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("seconds");

        out.println("<html><body>");
        out.println("<h2>Time Converter Result</h2>");

        try {
            int totalSeconds = Integer.parseInt(input);

            if (totalSeconds < 0) {
                out.println("<p style='color:red;'>Please enter a positive number of seconds.</p>");
            } else {
                int hours = totalSeconds / 3600;
                int minutes = (totalSeconds % 3600) / 60;
                int seconds = totalSeconds % 60;

                String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                double totalMinutes = totalSeconds / 60.0;
                long milliseconds = (long) totalSeconds * 1000;

                out.println("<p><b>Total Seconds:</b> " + totalSeconds + "</p>");
                out.println("<p><b>Time Format (HH:MM:SS):</b> " + formattedTime + "</p>");
                out.println("<p><b>Equivalent Minutes:</b> " + String.format("%.2f", totalMinutes) + "</p>");
                out.println("<p><b>Total Milliseconds:</b> " + milliseconds + "</p>");
            }

        } catch (Exception e) {
            out.println("<p style='color:red;'>Invalid input. Please enter seconds as a number.</p>");
        }

        out.println("<br><a href='index.html'>Convert Again</a>");
        out.println("</body></html>");
    }
}