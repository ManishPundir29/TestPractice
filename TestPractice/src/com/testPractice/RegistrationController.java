package com.testPractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
  //  mav.addObject("user", new User());
    System.out.println("hello");
    return "register";
  }
  
 
  @RequestMapping(value = "/test", method = RequestMethod.GET)
 @ResponseBody public String showRegister1(HttpServletRequest request, HttpServletResponse response) throws IOException {
	  System.out.println("hello again");
	  /********************************/
	  // A Runtime object has methods for dealing with the OS
	    Runtime r = Runtime.getRuntime();
	    Process p;     // Process tracks one external native process
		String[] cmd = { "cmd", "/c", "ping www.google.com"  }; 
	    BufferedReader is;  // reader for output of process
	    String line;
	    String str = "";
	   
	    p = r.exec(cmd);

	    System.out.println("In Main after exec");

	   
	    is = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    while ((line = is.readLine()) != null) {
	      System.out.println(line);
	      str +=line+"\n";
	    }
	    System.out.println("In Main after EOF");
	    System.out.flush();
	    try {
	      p.waitFor();  // wait for process to complete
	    } catch (InterruptedException e) {
	      System.err.println(e);  // "Can'tHappen"
	    //  return;
	    }
	    System.err.println("Process done, exit status was " + p.exitValue());
	    str+="Process done, exit status was " + p.exitValue();
    return str;
  }
  @RequestMapping(value = "/test2", method = RequestMethod.GET)
 @ResponseBody public String showRegister11(HttpServletRequest request, HttpServletResponse response) throws IOException {
	 // System.out.println("hello again");
		String line=null;
				String str = "";
	  Process proc = null; 
		String[] cmd = { "cmd", "/c", "ping 127.0.0.1" }; 
		proc = Runtime.getRuntime().exec(cmd);
		
		InputStream inputStream = proc.getInputStream(); 
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream); 
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			while ((line = bufferedReader.readLine()) != null) {
				str +=line+"\n";
			 	}
    return str;
  }
  
}