package com.baizhi.action;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SecurityAction extends ActionSupport{


	
	public void getCode(){
		
		//1.生成随机数
		String code = SecurityCode.getSecurityCode();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("code", code);		
		
		//2.生成图片
		BufferedImage image = SecurityImage.createImage(code);
		
		//3.获取一个输出流 验证码图片响应到客户端
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			ImageIO.write(image, "png", outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
