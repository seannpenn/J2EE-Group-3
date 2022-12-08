package Group3.Group3prelims.confirm_slip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group3.Group3prelims.confirm_slip.entity.Confirmslip;



@Repository
public interface IConfirmSlipRepository extends JpaRepository<Confirmslip, Integer>{
	public List<Confirmslip> findConfirmSlipByUser(Integer userID);
	public List<Confirmslip> findByUserID(Integer id);
}
