package controller;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import other.FileUtil;

public class LevelOneController extends SimpleFormController {
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String number = request.getSession().getAttribute("number").toString();
		RegCommand regCommand = (RegCommand) command;
		String question = regCommand.getLogin();
		String level = regCommand.getLevel();
		String var1 = regCommand.getVar1();
		String var2 = regCommand.getVar2();
		String var3 = regCommand.getVar3();
		String var4 = regCommand.getVar4();
		String var5 = regCommand.getVar5();
		Integer kilkist;
		String a1 = "0";
		String a2 = "0";
		String a3 = "0";
		String a4 = "0";
		String a5 = "0";
		String uri = request.getSession().getServletContext().getRealPath("/WEB-INF/");        
		FileUtil util = new FileUtil();
		util.removeLineFromFile(uri+"\\test"+number+".xml", "</test>");
		FileWriter file = new FileWriter(uri+"\\test"+number+".xml", true);		
		if (var3==null||var3.equals("")) {
			file.write("<question name=\""+question+"\" level=\""+level+"\" count=\"2\">\n");
			if (regCommand.getCorrect().equals("2")){
				a2 = "1";				
			} else { 
				a1 = "1";	
			}
            file.write("     <answer bal=\""+a1+"\" name=\""+var1+"\" />\n");
            file.write("     <answer bal=\""+a2+"\" name=\""+var2+"\" />\n");
            file.write("</question>\n");
            file.write("</test>");
            file.flush();
            file.close();
			kilkist = 2; 
		} else if (var4==null||var4.equals("")) {
			file.write("<question name=\""+question+"\" level=\""+level+"\" count=\"3\">\n");
			if (regCommand.getCorrect().equals("1")){
				a1 = "1";
			} else if (regCommand.getCorrect().equals("2")) { 
				a2 = "1";				
			} else a3 = "1";			
            file.write("     <answer bal=\""+a1+"\" name=\""+var1+"\" />\n");
            file.write("     <answer bal=\""+a2+"\" name=\""+var2+"\" />\n");
            file.write("     <answer bal=\""+a3+"\" name=\""+var3+"\" />\n");
            file.write("</question>\n");
            file.write("</test>");
            file.flush();
            file.close();
			kilkist = 3;
		} else if (var5==null||var5.equals("")) {
			file.write("<question name=\""+question+"\" level=\""+level+"\" count=\"4\">\n");
			if (regCommand.getCorrect().equals("1")){
				a1 = "1";
			} else if (regCommand.getCorrect().equals("2")) { 
				a2 = "1";				
			} else if (regCommand.getCorrect().equals("3")) {
				a3 = "1";			
			} else a4 = "1";
            file.write("     <answer bal=\""+a1+"\" name=\""+var1+"\" />\n");
            file.write("     <answer bal=\""+a2+"\" name=\""+var2+"\" />\n");
            file.write("     <answer bal=\""+a3+"\" name=\""+var3+"\" />\n");
            file.write("     <answer bal=\""+a4+"\" name=\""+var4+"\" />\n");
            file.write("</question>\n");
            file.write("</test>");
            file.flush();
            file.close();
			kilkist = 4;
		} else {
			file.write("<question name=\""+question+"\" level=\""+level+"\" count=\"5\">\n");
			if (regCommand.getCorrect().equals("1")){
				a1 = "1";
			} else if (regCommand.getCorrect().equals("2")) { 
				a2 = "1";				
			} else if (regCommand.getCorrect().equals("3")) {
				a3 = "1";			
			} else if (regCommand.getCorrect().equals("4")) {
				a4 = "1";			
			} else a5 = "1";
            file.write("     <answer bal=\""+a1+"\" name=\""+var1+"\" />\n");
            file.write("     <answer bal=\""+a2+"\" name=\""+var2+"\" />\n");
            file.write("     <answer bal=\""+a3+"\" name=\""+var3+"\" />\n");
            file.write("     <answer bal=\""+a4+"\" name=\""+var4+"\" />\n");
            file.write("     <answer bal=\""+a5+"\" name=\""+var5+"\" />\n");
            file.write("</question>\n");
            file.write("</test>");
            file.flush();
            file.close();
			kilkist = 5;			
		}		
		Integer correct = Integer.valueOf(regCommand.getCorrect());
		String level2 = regCommand.getLevel2();
		System.out.println(question+"   "+var1+"    "+var2);
		System.out.println("  "+var3+"   "+var4+"    "+var5);
		System.out.println("  "+level+"   "+correct+"    "+level2);
		System.out.println(" kilkist "+kilkist);
		
		if (level2!=null) return new ModelAndView("redirect:addLevel2.htm");
		return new ModelAndView("redirect:addLevel1.htm");
	}

	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		// TODO Auto-generated method stub
		String parametr = request.getParameter("finish");
		if (parametr != null && parametr.equals("Завершити")) {
			return new ModelAndView("redirect:adminProfile.htm");
		}
		return super.processFormSubmission(request, response, command, errors);
	}	
}
