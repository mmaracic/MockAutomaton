/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;

/**
 *
 * @author Marijo
 */

public class AutomatonServlet extends HttpServlet{
    
    private final AutomatonExecutor automatonExecutor;

    public AutomatonServlet(AutomatonExecutor executor) {
        this.automatonExecutor = executor;
    }
        
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        int length = req.getContentLength();
        byte[] buffer = new byte[length];
        ServletInputStream sis = req.getInputStream();
        int bytesRead = sis.read(buffer);
        if (bytesRead != length){
            throw new ServletException("Content read error: Read "+bytesRead+" instead of "+length+"bytes");
        }
        String body = new String(buffer);
        this.automatonExecutor.processEvent(path, body);        
    }
}
