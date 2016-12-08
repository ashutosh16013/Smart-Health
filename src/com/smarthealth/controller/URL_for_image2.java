package com.smarthealth.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class URL_for_image2
 */
//@WebServlet("/URL_for_image2")
public class URL_for_image2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URL_for_image2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<String> detail_user=(List<String>)session.getAttribute("uname");
		boolean []forward = new boolean[3];
		String []name = new String[3];
		String fileName = "";
		if(ServletFileUpload.isMultipartContent(request)){
			
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try{
				List<?> items = upload.parseRequest(request);
				Iterator<?> iterator = items.iterator();
				while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        fileName = item.getName();  if(fileName.equals("")){
                        	response.sendRedirect("User.jsp");
                        	return;
                        }
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "/" + detail_user.get(1));
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
 
                        File uploadedFile = new File(root + "/" + detail_user.get(1) + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                        forward[0] = true; name[0] = "";
            			forward[1] = false; name[1] = detail_user.get(1)+ "\\" + fileName;
            			forward[2] = false; name[2] = "";
            			Login obj = new Login();
            			obj.result = detail_user.get(1);
            			obj.upload_pic2(name[1]);
                    }
                }
			}catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	//}
	response.sendRedirect("User.jsp");
	}
}
