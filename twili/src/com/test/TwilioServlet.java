package com.test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

/**
 * Servlet implementation class TwilioServlet
 */
@WebServlet("/TwilioServlet")
public class TwilioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwilioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
			
			 // Create a TwiML response and add our friendly message.
			 // Create a dict of people we know.
	        HashMap<String, String> callers = new HashMap<String, String>();
	        callers.put("14158675309", "Curious George");
	        callers.put("14158675310", "Boots");
	        callers.put("14158675311", "Virgil");

	        String fromNumber = request.getParameter("From");
	        System.out.println("fromNumber"+fromNumber);
	        
	        String knownCaller = callers.get(fromNumber);
	        String message;
	        if (knownCaller == null) {
	            // Use a generic message
	            message = "Hello Sridhar";
	        } else {
	            // Use the caller's name
	            message = "Hello " + knownCaller;
	        }

	        // Create a TwiML response and add our friendly message.
	        VoiceResponse twiml = new VoiceResponse.Builder()
	                .say(new Say.Builder(message).build())
	                .build();

	        response.setContentType("application/xml");
	        try {
	            response.getWriter().print(twiml.toXml());
	        } catch (TwiMLException e) {
	            e.printStackTrace();
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
