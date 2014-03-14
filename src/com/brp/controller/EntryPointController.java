package com.brp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.brp.bean.UserBean;
import com.brp.service.UserService;

@Controller
@SessionAttributes({"sessionuser"})
public class EntryPointController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index"} )
	public ModelAndView doLogin(@ModelAttribute UserBean userBean,ModelMap modelMap,HttpServletRequest request,HttpSession hs) {
		
	
		String redirectTo=null;
		UserBean sendUserBean = null;
		if(hs.getAttribute("sessionuser")!=	null && ((UserBean)hs.getAttribute("sessionuser")).getEmail()!=null){
			redirectTo="welcomeuser";
			sendUserBean = (UserBean)hs.getAttribute("sessionuser");
		}else{
			redirectTo="index";
			sendUserBean = new UserBean();
		}
		
		modelMap.addAttribute("userBean",sendUserBean);
		return new ModelAndView(redirectTo, modelMap);	
	}
	
	
	@RequestMapping(value = "/welcomeuser")
	public ModelAndView signupUser(@ModelAttribute UserBean userBean, ModelMap modelMap,HttpServletRequest request,HttpSession hs) {
		
		String sessionEmail = null;
		String email = userBean.getEmail();
		
		
			if(hs.getAttribute("sessionuser")!=null){
				sessionEmail = ((UserBean)hs.getAttribute("sessionuser")).getEmail();
				System.out.println("in signupUser : session value:" +sessionEmail);
				
			}
		
			
			String redirectTo=null;
			UserBean sendUserBean = null;
			
			
			if(hs.getAttribute("sessionuser")!=null && (sessionEmail!=null || email!=null)){
				
				System.out.println("FROM 1");
				if(email!=null && sessionEmail==null){
					redirectTo = "welcomeuser";
					sendUserBean = userBean;
				}
				else{
					redirectTo = "welcomeuser";
					sendUserBean = (UserBean)hs.getAttribute("sessionuser");
				}
				
				
			}else if(hs.getAttribute("sessionuser")==null && email!=null){
				
				System.out.println("FROM 2");
				if(email!=null){
					redirectTo = "welcomeuser";
					sendUserBean = userBean;
				}else{
					redirectTo = "welcomeuser";
					sendUserBean = (UserBean)hs.getAttribute("sessionuser");
				}
				
			}	
			else{
				System.out.println("FROM 3");
				redirectTo = "index";
				sendUserBean = new UserBean();
				
			}
			
			
			if(redirectTo.equals("welcomeuser")){
				sendUserBean=userService.signInUser(sendUserBean);
				if(sendUserBean!=null){
					redirectTo = "welcomeuser";
					
				}else{
					redirectTo = "redirect:index";
					sendUserBean = new UserBean();
				}
			}
			

			modelMap.addAttribute("userBean", sendUserBean);
			return new ModelAndView(redirectTo,modelMap).addObject("sessionuser",sendUserBean);
		
			
	}
	
	
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoutUser(@ModelAttribute UserBean userBean, ModelMap modelMap,
			HttpServletRequest request,HttpSession hs,SessionStatus status) {
			modelMap.remove("userBean");
			hs.invalidate();
			return new ModelAndView("redirect:index", modelMap).addObject("sessionuser",userBean);		
	}

	
}
