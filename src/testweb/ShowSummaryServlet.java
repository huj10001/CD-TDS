package testweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowSummary
 */
public class ShowSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("lala");
//		response.getWriter().append(""+getServletContext().getAttribute("a"));
//		Enumeration<String> names = getServletContext().getAttributeNames();
//		while(names.hasMoreElements()){
//			response.getWriter().append(""+getServletContext().getAttribute(names.nextElement()));
//		}
		ServletContext context = request.getServletContext();
        Enumeration<String> attributeNames = context.getAttributeNames();
        List list= Collections.list(attributeNames);
        Collections.sort(list);
        attributeNames = Collections.enumeration(list);
//        int i = 0;
        while (attributeNames.hasMoreElements()) {
            String nextElement = attributeNames.nextElement();
//            System.out.print(++i + ":" + nextElement + ":");
//            Object attribute = context.getAttribute(nextElement);
//            System.out.println(attribute);
            if(nextElement.length() < 10){
//            	response.getWriter().append("#"+nextElement + ":");
            	response.getWriter().append("#"+nextElement);
            	ArrayList al = (ArrayList) context.getAttribute(nextElement);
            	for(int i=0; i<al.size();i++){
//            		System.out.println("size is : " + al.size());
//            		if(al.get(i) != ""){
//            			response.getWriter().append("*Device"+(i+1)+":"+al.get(i));
            			response.getWriter().append("*"+al.get(i));
//            		}
//            		else{
//            			response.getWriter().append("Device"+(i+1)+":"+"\t"+al.get(i));
//            		}
            	}
//            response.getWriter().append(nextElement + ":" + context.getAttribute(nextElement)+"\n");
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
