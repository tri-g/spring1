package src.org.slk;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import src.org.slk.model.User;

@Controller
public class MainController 
{
	/*@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcome()
	{
		return "Hello";
	}
	@RequestMapping("Display")
	public String Display(HttpServletRequest request)
	{
		String firstname=request.getParameter("firstname");
		request.setAttribute("firstname", firstname);
		return "Display";
	}
	@RequestMapping("display")
	public ModelAndView Display(@RequestParam("firstName") String firstName)
	{
		ModelAndView mv=new ModelAndView("Display");
		Date date=new Date();
		List<String> n=new ArrayList<>();
		n.add("tony");
		n.add("steve");
		n.add("bruce");
		n.add("vision");
		mv.addObject("date",date);
		mv.addObject("name",firstName);
		mv.addObject("team",n);
		return mv;		
	}*/
	
	@GetMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("userFormView");
		User user=new User();
		mv.addObject("user",user);
		return mv;
	}
	@PostMapping("/displayUserInfo")
	public ModelAndView displayUserInfo(@ModelAttribute User user)
	{
		ModelAndView mv=new ModelAndView("displayUserInfo");
		System.out.println(user);
		mv.addObject("user",user);
		return mv;
	}
}
