package lk.restaurant.Repository;

import lk.restaurant.Model.M_void_reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVoidRepository extends JpaRepository<M_void_reason,Long> {
}
