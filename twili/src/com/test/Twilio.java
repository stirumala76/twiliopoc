package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

/**
 * Servlet implementation class Twilio
 */
@WebServlet("/Twilio")
public class Twilio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Twilio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 // Create a TwiML response and add our friendly message.
        response.setContentType("application/xml");
		VoiceResponse voiceResponse = new VoiceResponse.Builder()
                .say(new Say.Builder("Hello Monkey").build())
                .build();


        try {
            response.getWriter().print(voiceResponse.toXml());
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
