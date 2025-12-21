package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class SimpleHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setStatus(200);
            resp.setContentType("text/plain");
            resp.getWriter().write("Hello from Simple Servlet");
        } catch (Exception ignored) {}
    }
}
