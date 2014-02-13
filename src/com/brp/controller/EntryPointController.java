package com.brp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(EntryPointController.class);
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView doLogin(ModelMap modelMap,HttpServletRequest request,HttpSession hs) {
		
		logger.info("in doLogin");
		
		//HttpSession hs = request.getSession();
		String redirectTo=null;
		UserBean sendUserBean = null;
		if(hs.getAttribute("sessionuser")!=	null && ((UserBean)hs.getAttribute("sessionuser")).getEmail()!=null){
			
			redirectTo="welcomeuser";
			sendUserBean = (UserBean)hs.getAttribute("sessionuser");
			
		}else{
			redirectTo="index";
			sendUserBean = new UserBean();
		}
		
		modelMap.addAttribute("userdetails",sendUserBean);
		logger.info("---------------------doLogin completed----------------------------------");
		
		
		return new ModelAndView(redirectTo, modelMap);		
		//return "index";
	}
	
	@RequestMapping(value = "/welcomeuser")
	public ModelAndView signupUser(@ModelAttribute("userdetails") UserBean userBeanObj, ModelMap modelMap,HttpServletRequest request,HttpSession hs) {
		
		
		
		//HttpSession hs = request.getSession();
		
		
		logger.info("in signupUser : object value:" +userBeanObj.getEmail());
		
		
		if(hs.getAttribute("sessionuser")!=null)
			logger.info("in signupUser : session value:" +((UserBean)hs.getAttribute("sessionuser")).getEmail());
		
			
			String redirectTo=null;
			UserBean sendUserBean = null;
		
			if(hs.getAttribute("sessionuser")!=null && 
					
					(((UserBean)hs.getAttribute("sessionuser")).getEmail()!=null || userBeanObj.getEmail()!=null)){
				
				logger.info("FROM 1");
				if(userBeanObj.getEmail()!=null && ((UserBean)hs.getAttribute("sessionuser")).getEmail()==null){
					redirectTo = "welcomeuser";
					sendUserBean = userBeanObj;
					
				}
				
				else{
					redirectTo = "welcomeuser";
					sendUserBean = (UserBean)hs.getAttribute("sessionuser");
					
				}
				
				
			}else if(hs.getAttribute("sessionuser")==null && userBeanObj.getEmail()!=null){
				
				logger.info("FROM 2");
				if(userBeanObj.getEmail()!=null){
					redirectTo = "welcomeuser";
					sendUserBean = userBeanObj;
				}else{
					redirectTo = "welcomeuser";
					sendUserBean = (UserBean)hs.getAttribute("sessionuser");
				}
				
			}	
			else{
				logger.info("FROM 3");
				redirectTo = "index";
				sendUserBean = new UserBean();
				
			}
			
			logger.info("------------------------signupUser completed-------------------------------");
			modelMap.addAttribute("userdetails", sendUserBean);
			return new ModelAndView(redirectTo,modelMap).addObject("sessionuser",sendUserBean);
			
			
			/*if(hs.getAttribute("sessionuser")!=null && ((UserBean)hs.getAttribute("sessionuser")).getEmail()!=null){
				
				
				modelMap.addAttribute("userdetails",new UserBean());
				return new ModelAndView("index",modelMap).addObject("sessionuser",new UserBean());
				
			}else if(hs.getAttribute("sessionuser")!=null && ((UserBean)hs.getAttribute("sessionuser")).getEmail()==null && userBeanObj.getEmail()==null){
				
				modelMap.addAttribute("userdetails",new UserBean());
				return new ModelAndView("index",modelMap).addObject("sessionuser",new UserBean());
				
			}else{
				
				//userBeanObj.setEmail(userBeanObj.getEmail());
				modelMap.addAttribute("userdetails", userBeanObj);
				return new ModelAndView("welcomeuser",modelMap).addObject("sessionuser",userBeanObj);
			
			
			}*/
		//return new ModelAndView("welcomeuser",modelMap).addObject("sessionuser",userBeanObj);
		
		/*}else{
			logger.info("session null null in welcome");	
			userBeanObj.setEmail(userBeanObj.getEmail());
			model.addAttribute("userdetails", userBeanObj);
			return new ModelAndView("welcomeuser",model).addObject("sessionuser",userBeanObj);
		}*/
		
		
//		if(userBeanObj!=null){
//			logger.info("after login : "+userBeanObj.getEmail());
//			userBeanObj.setEmail(userBeanObj.getEmail());
//			model.addAttribute("userdetails", userBeanObj);
//			return new ModelAndView("welcomeuser",model).addObject("sessionuser",userBeanObj);
//		}else{
//			model.addAttribute("userdetails",new UserBean());
//			return new ModelAndView("index",model).addObject("sessionuser",new UserBean());
//		}
			
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoutUser(@ModelAttribute("userdetails") UserBean userBeanObj, ModelMap modelMap,HttpServletRequest request,HttpSession hs) {
		
			logger.info("in logoutUser : object value:" +userBeanObj.getEmail());
			
			modelMap.addAttribute("userdetails", new UserBean());
			
			/*modelMap.remove("user");
			modelMap.addAttribute("user",new UserBean());*/
			
			
			//HttpSession hs = request.getSession();
			logger.info("in logoutUser : session value:" +((UserBean)hs.getAttribute("sessionuser")).getEmail());
			hs.invalidate();
			logger.info("------------------------logoutUser completed-------------------------------");
			return new ModelAndView("index", modelMap).addObject("sessionuser",new UserBean());		
		
	}

	
}
