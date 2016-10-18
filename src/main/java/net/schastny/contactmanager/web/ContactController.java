package net.schastny.contactmanager.web;

import java.util.HashMap;
import java.util.Map;

import net.schastny.contactmanager.domain.Contact;
import net.schastny.contactmanager.domain.Stringsearch;
import net.schastny.contactmanager.service.ContactService;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

	String searchrequest;

	@Autowired
	private ContactService contactService;

	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "contact";
	}



	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}

	/*@RequestMapping("/hi")
	public String hello(Map<String, Object> map) {
		
		Map<String, Object> map2;
		map2=new HashMap();

		map.put("contactList", contactService.listContact());

		//map2.put("contactList2", contactService.listContact());

		return "hello";
	}*/

	/*@RequestMapping("/hi")
	public ModelAndView hello(Map<String, Object> map) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("contactList2",  contactService.listContact());
		//mav.addObject("path", "/hi");
		return mav;
	}*/


	@RequestMapping(value = "/addhi", method = RequestMethod.POST)
	public String addContactHi(@ModelAttribute("contact") Contact contact,
							 BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/hi";
	}

	@RequestMapping(value = "/hi")
	public String simpleModel1(Model model) {
		model.addAttribute("contactList2", contactService.listContact());
		//model.addAttribute("contactList3", contactService.listContact());
		model.addAttribute("contact", new Contact());
		//model.addAttribute("path", "/simplemodel1");
		return "hello";
	}

	@RequestMapping(value = "/usersearch")
	public String userSearch(Model model) {
		//model.addAttribute("contactList2", contactService.listContact());
		model.addAttribute("srtingsearch", new Stringsearch());
		model.addAttribute("contactList3", contactService.findContact(searchrequest));

		return "sitesearch";
	}


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchContact(@ModelAttribute("srtingsearch") Stringsearch stringsearch,
                               BindingResult result) {


		searchrequest=stringsearch.getName();
		System.out.println(
				" email entered "+ stringsearch.getName()+ "\n"
		);

//добавил сейчас
		//комент еще один
        return "redirect:/usersearch";
    }
}
