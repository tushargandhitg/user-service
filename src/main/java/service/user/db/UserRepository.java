package service.user.db;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Transactional(readOnly=false)
	@Modifying
	@Query("UPDATE User SET credits = (:credits) WHERE userid = (:userid)")
	public void updateCredits(@Param("userid") Integer userid, @Param("credits") Double credits);
	
	@Transactional(readOnly=false)
	@Modifying
	@Query("UPDATE User SET credits = (credits + (:credits)) WHERE userid = (:userid)")
	public void addCredits(@Param("userid") Integer userid,
							@Param("credits") Double credits);
}
