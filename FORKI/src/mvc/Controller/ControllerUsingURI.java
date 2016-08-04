package mvc.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class ControllerUsingURI extends HttpServlet {

	private Map commandMap=new HashMap();
	
	public void init(ServletConfig config)throws ServletException{
		String props=config.getInitParameter("propertyConfig");
		Properties pr=new Properties();
		FileInputStream f= null;
		
		try{
			f=new FileInputStream(props);
			pr.load(f);
		}catch(IOException e){
			throw new ServletException(e);
		}finally{
			if(f!=null)try{f.close();}catch(IOException e){}
		}
		Iterator keyIter =pr.keySet().iterator();
		while(keyIter.hasNext()){
			String command=(String)keyIter.next();
			String handlerClassName=pr.getProperty(command);
			try{
				Class handlerClass=Class.forName(handlerClassName);
				Object handlerInstance=handlerClass.newInstance();
				commandMap.put(command, handlerInstance);
			}catch(ClassNotFoundException e){
				throw new ServletException(e);
			}catch(InstantiationException e){
				throw new ServletException(e);
			}catch(IllegalAccessException e){
				throw new ServletException(e);
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		requestPro(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		requestPro(request,response);
	}
	private void requestPro(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	  String view=null;
	  CommandAction com=null;
	  try{
		  String command=request.getRequestURI();
		  System.out.println(command);
		  if(command.indexOf(request.getContextPath())==0){
			  command=command.substring(request.getContextPath().length());
		  }
		  com=(CommandAction)commandMap.get(command);
		  view=com.requestPro(request,response);
	  }catch(Throwable e){
		  throw new ServletException(e);
	  }
	  RequestDispatcher dispatcher=request.getRequestDispatcher(view);
	  dispatcher.forward(request, response);
	}
}
