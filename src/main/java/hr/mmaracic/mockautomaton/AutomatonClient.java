/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton;

import hr.mmaracic.mockautomaton.model.AutomatonSchema;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author mmaracic
 */
public class AutomatonClient {

    private final static Logger logger = Logger.getLogger(AutomatonClient.class);
    
    public static String postRequest(String protocol, String host, String port, String path, Map<String, Object> params, String body, AutomatonSchema.AutomatonType bodyType)
            throws MalformedURLException, IOException {
        StringBuilder strUrl = new StringBuilder(protocol + "://" + host + ":" + port + "/" + path);
        if (params.size() > 0) {
            strUrl.append("?");
            for (String param : params.keySet()) {
                if (!strUrl.toString().endsWith("?")) {
                    strUrl.append("&");
                }
                strUrl.append(param).append("=").append(params.get(param));
            }
        }
        URL url = new URL(strUrl.toString());

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        
        //ToDo Content Type

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(body);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        logger.log(Level.INFO, "Request to: "+strUrl+" returned code: "+responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
