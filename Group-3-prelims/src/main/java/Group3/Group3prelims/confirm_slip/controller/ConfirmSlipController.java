package Group3.Group3prelims.confirm_slip.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Group3.Group3prelims.common.models.ApiResponse;
import Group3.Group3prelims.confirm_slip.entity.Confirmslip;
import Group3.Group3prelims.confirm_slip.service.ConfirmSlipService;
import Group3.Group3prelims.message.AppMessages;
import Group3.Group3prelims.ticket.entity.Ticket;
import Group3.Group3prelims.ticket.service.TicketService;

@RestController
@CrossOrigin("*")
public class ConfirmSlipController {
	@Autowired
	private ConfirmSlipService confirmSlipService;
	
	
	@PostMapping("/confirm_slip/create")
	@ResponseBody
	
	public ApiResponse save(Confirmslip slip) throws IOException {

		Confirmslip savedSlip = confirmSlipService.saveConfirmSlip(slip);
		
		if (savedSlip != null) {
			return ApiResponse.CreateSuccess(savedSlip, AppMessages.TICKET_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@PutMapping("/confirm_slip/update")
	@ResponseBody
	public ApiResponse update(Confirmslip slip) throws IOException
	{
		Confirmslip updatedSlip = confirmSlipService.updateConfirmSlip(slip);
		if (updatedSlip != null) {
			return ApiResponse.CreateSuccess(updatedSlip, AppMessages.TICKET_SUCCESSFULLY_UPDATED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@DeleteMapping("/confirm_slip/delete/{id}")
	@ResponseBody
	public ApiResponse deleteSlip(@PathVariable final int id) {
		Confirmslip slip = confirmSlipService.deleteConfirmSlip(id);
		if (slip != null) {
			return ApiResponse.CreateSuccess("Successfully deleted");
		}
		return ApiResponse.CreateError("Unsuccessfull");
	}
	
	@GetMapping("/confirm_slip/slip_user/{id}")
	@ResponseBody
	
	public ApiResponse findConfirmSlipByUser(@PathVariable final int id) {
		List<Confirmslip> slip = confirmSlipService.findConfirmSlipByUser(id);
		if(slip != null && slip.size() != 0) {
			return ApiResponse.CreateSuccess(slip, AppMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@GetMapping("/confirm_slip/slip/{id}")
	@ResponseBody
	
	public ApiResponse getConfirmSlip(@PathVariable final int id) {
		Confirmslip slip = confirmSlipService.getConfirmSlip(id);
		if(slip != null) {
			return ApiResponse.CreateSuccess(slip, AppMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@GetMapping("/confirm_slip/all")
	@ResponseBody
	public ApiResponse getAllSlips() {
		List<Confirmslip> allSlips = confirmSlipService.getAllConfirmSlip();
		if (allSlips != null) {
			return ApiResponse.CreateSuccess(allSlips, AppMessages.TICKETS_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
}
