package com.cg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.entity.Trainee;
import com.cg.service.ITraineeService;


@Controller
public class TraineeController {
	
	@Autowired
	ITraineeService traineeService;

	@RequestMapping(value="run",method=RequestMethod.GET)
	public String sayHello()
	{
		return "Welcome";
	}
	
	@RequestMapping(value="addTrainee",method=RequestMethod.GET)
	public String addEmployee(@ModelAttribute("trainee") Trainee trainee,Map<String,Object> model ){
		List<String> traineeLocation = new ArrayList<String>();
		traineeLocation.add("Chennai");
		traineeLocation.add("Bangalore");
		traineeLocation.add("Delhi");
		model.put("traineeLocation",traineeLocation);
		model.put("trainee",trainee);
		model.put("domain", new String[] { "JEE", "VnV", "DNeT", "Android" });
		return "Add_Trainee";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView insertEmployee(@Valid@ModelAttribute("trainee") Trainee trainee,BindingResult result,
			Map<String,Object> model){
		int id=0;
		if(result.hasErrors()){
			List<String> traineeLocation = new ArrayList<String>();
			traineeLocation.add("Chennai");
			traineeLocation.add("Bangalore");
			traineeLocation.add("Delhi");
			model.put("traineeLocation",traineeLocation);
			model.put("domain", new String[] { "JEE", "VnV", "DNeT", "Android" });
			return new ModelAndView("Add_Trainee");
		}else{
		 id=traineeService.save(trainee);		
		}
		return new ModelAndView("Welcome","trainee",id);
	}
	
	@RequestMapping(value="retrieveAll",method=RequestMethod.GET)
	public ModelAndView showAllTrainee(){
		List<Trainee> alltrainees=traineeService.loadAll();
		return new ModelAndView("RetrieveAll_Trainee","traineeList", alltrainees);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteEmployee(){
		
		return "Delete_Trainee";
	}
	
	@RequestMapping(value="del_Trainee",method=RequestMethod.GET)
	public String employeeDelete(@RequestParam("traineeid") int traineeid){
		traineeService.delete(traineeid);
		return "deleted";
		
	}
	

	@RequestMapping(value = "/update")
	public String updateTrainee(Model model) {
		Trainee trainee = new Trainee();
		List<String> domain = new ArrayList<String>();
		domain.add("JEE");
		domain.add("VnV");
		domain.add("DotNeT");
		model.addAttribute("domain", domain);
		model.addAttribute("trainee", trainee);
		return "Update_trainee";
	}

	@RequestMapping(value = "/Update_trainee")
	public String update_TraineeId(@ModelAttribute("trainee") Trainee trainee,
			Model model) {
	    trainee = traineeService.fetch(trainee.getTraineeId());
		trainee.setTraineeId(trainee.getTraineeId());
		List<String> traineeLocation = new ArrayList<String>();
		traineeLocation.add("Chennai");
		traineeLocation.add("Bangalore");
		traineeLocation.add("Delhi");
		model.addAttribute("traineeLocation", traineeLocation);
		model.addAttribute("domain", new String[] { "JEE", "VnV", "DNeT",
				"Android" });
		model.addAttribute("traineeRes", trainee);
		return "Update_trainee";
	}

	@RequestMapping(value = "/Update_Persisted_trainee")
	public String updatedTrainee(@ModelAttribute("traineeRes") Trainee trainee,
			Model model) {
		// Trainee trainee=new Trainee();
		trainee.setTraineeId(trainee.getTraineeId());
		trainee.setTraineeName(trainee.getTraineeName());
		trainee.setDomain(trainee.getDomain());
		trainee.setTraineeLocation(trainee.getTraineeLocation());
		traineeService.updateTrainee(trainee);
		System.out.println(trainee.getTraineeName());
		model.addAttribute("traineeRes", trainee);
		return "UpdateSuccess";
	}

	@RequestMapping(value = "/retrieve")
	public String retrieve_Detail(Model model) {
		Trainee trainee = new Trainee();
		model.addAttribute("trainee", trainee);
		return "Retrieve_Trainee";
	}

	@RequestMapping(value = "/retrieve_Trainee")
	public String retrieveEmployee(@ModelAttribute("trainee") Trainee trainee,BindingResult result,
			Model model) {
		Trainee traineeRes = traineeService.fetch(trainee.getTraineeId());
		String target=null;
		if(traineeRes==null || traineeRes.getTraineeId()==0)
		{
			target="Failure";
		model.addAttribute("error","NULL Pointer Exception Occured");
		}
		else{
			target="display";
			model.addAttribute("traineeList", traineeRes);	
		}
		
		return target;
	}
}
