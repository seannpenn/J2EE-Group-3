package Group3.Group3prelims.confirm_slip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group3.Group3prelims.confirm_slip.entity.Confirmslip;
import Group3.Group3prelims.confirm_slip.repository.IConfirmSlipRepository;
import Group3.Group3prelims.ticket.entity.Ticket;

@Service
public class ConfirmSlipServiceImpl implements ConfirmSlipService{
	@Autowired
	private IConfirmSlipRepository confirmJpaRepository;
	
	public Confirmslip saveConfirmSlip(Confirmslip slip) {
		return confirmJpaRepository.saveAndFlush(slip);
	}
	public Confirmslip updateConfirmSlip(Confirmslip slip) {
		Confirmslip existingSlip = confirmJpaRepository.findById(slip.getConfirmID()).get();
		existingSlip.setConfirmID(slip.getConfirmID());
		existingSlip.setConfirmUser(slip.getConfirmUser());
		existingSlip.setConfirmTicket(slip.getConfirmTicket());
		existingSlip.setConfirmDate(slip.getConfirmDate());
		existingSlip.setConfirmDesc(slip.getConfirmDesc());	
		existingSlip.setConfirmSignatures(slip.getConfirmSignatures());
		existingSlip.setConfirmAmount(slip.getConfirmAmount());
		return confirmJpaRepository.saveAndFlush(existingSlip);
	}
	public List<Confirmslip> getAllConfirmSlip(){
		return confirmJpaRepository.findAll();
	}
	public Confirmslip getConfirmSlip(Integer id) {
		return confirmJpaRepository.findById(id).get();
	}

	public Confirmslip deleteConfirmSlip(Integer id){
		Confirmslip chosenSlip = confirmJpaRepository.findById(id).get();
		if(chosenSlip != null) {
			confirmJpaRepository.delete(chosenSlip);
			return chosenSlip;
		}
		
		return null;
	}
	public List<Confirmslip> findConfirmSlipByUser(Integer id){
		return confirmJpaRepository.findByUserID(id);
	}
	public Confirmslip findConfirmSlipByTicket(Integer id){
		return confirmJpaRepository.findById(id).get();
	}
}
