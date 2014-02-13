package com.brp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.brp.bean.UserBean;

@Controller
@SessionAttributes({"sessionuser"})
public class EntryPointController {
	
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView doLogin(ModelMap model) {
		
		System.out.println("in doLogin");
		
		model.addAttribute("userdetails",new UserBean());
		model.addAttribute("user",new UserBean());
		
		return new ModelAndView("index", model);		
		//return "index";
	}
	
	@RequestMapping(value = "/signup")
	public ModelAndView signupUser(@ModelAttribute("user") UserBean userBeanObj, ModelMap modelMap,HttpServletRequest request) {
		
		System.out.println("in signupUser");
		
		HttpSession hs = request.getSession();
		
		
		
			System.out.println("user email"+userBeanObj.getEmail());
			
			//System.out.println("session value in welcome: "+((UserBean)hs.getAttribute("sessionuser")).getEmail());
			if(hs.getAttribute("sessionuser")!=null && ((UserBean)hs.getAttribute("sessionuser")).getEmail()!=null){
				
				
				modelMap.addAttribute("userdetails",new UserBean());
				return new ModelAndView("index",modelMap).addObject("sessionuser",new UserBean());
				
			}else if(hs.getAttribute("sessionuser")!=null && ((UserBean)hs.getAttribute("sessionuser")).getEmail()==null && userBeanObj.getEmail()==null){
				
				modelMap.addAttribute("userdetails",new UserBean());
				return new ModelAndView("index",modelMap).addObject("sessionuser",new UserBean());
				
			}else{
				
				userBeanObj.setEmail(userBeanObj.getEmail());
				modelMap.addAttribute("userdetails", userBeanObj);
				return new ModelAndView("welcomeuser",modelMap).addObject("sessionuser",userBeanObj);
			
			
			}
			
		/*}else{
			System.out.println("session null null in welcome");	
			userBeanObj.setEmail(userBeanObj.getEmail());
			model.addAttribute("userdetails", userBeanObj);
			return new ModelAndView("welcomeuser",model).addObject("sessionuser",userBeanObj);
		}*/
		
		
//		if(userBeanObj!=null){
//			System.out.println("after login : "+userBeanObj.getEmail());
//			userBeanObj.setEmail(userBeanObj.getEmail());
//			model.addAttribute("userdetails", userBeanObj);
//			return new ModelAndView("welcomeuser",model).addObject("sessionuser",userBeanObj);
//		}else{
//			model.addAttribute("userdetails",new UserBean());
//			return new ModelAndView("index",model).addObject("sessionuser",new UserBean());
//		}
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoutUser(@ModelAttribute("user") UserBean userBeanObj, ModelMap modelMap,HttpServletRequest request) {
		
			System.out.println("in logoutUser");
			System.out.println("after logout" +userBeanObj.getEmail());
			
			modelMap.addAttribute("userdetails", new UserBean());
			
			modelMap.remove("user");
			modelMap.addAttribute("user",new UserBean());
			
			
			HttpSession hs = request.getSession();
			System.out.println("session value in logout : "+((UserBean)hs.getAttribute("sessionuser")).getEmail());
			hs.invalidate();
			
			return new ModelAndView("index", modelMap).addObject("sessionuser",new UserBean());		
		
	}

	
}
