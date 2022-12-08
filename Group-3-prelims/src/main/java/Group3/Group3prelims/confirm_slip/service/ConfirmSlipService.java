package Group3.Group3prelims.confirm_slip.service;

import java.util.List;

import Group3.Group3prelims.confirm_slip.entity.Confirmslip;
import Group3.Group3prelims.ticket.entity.Ticket;

public interface ConfirmSlipService {
	public Confirmslip saveConfirmSlip(Confirmslip confirm_slip);
	public Confirmslip updateConfirmSlip(Confirmslip confirm_slip);
	public List<Confirmslip> getAllConfirmSlip();
	public Confirmslip getConfirmSlip(Integer id);
	public Confirmslip deleteConfirmSlip(Integer id);

//	public Confirm_Slip findBySubject(String test);
	public List<Confirmslip> findConfirmSlipByUser(Integer id);
//	public List<Confirm_Slip> findByCreateDate(String date);
}
