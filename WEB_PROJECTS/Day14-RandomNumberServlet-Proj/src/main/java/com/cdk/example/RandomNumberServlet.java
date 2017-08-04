package com.cdk.example;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RandomNumberServlet extends javax.servlet.http.HttpServlet {
    public void service(ServletRequest req,ServletResponse res) throws IOException {
        PrintWriter printWriter=res.getWriter();
        printWriter.write("Random" + Math.random()+"Date"+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"Time"+new SimpleDateFormat("HH:mm:ss").format(new Date()));

    }
}
