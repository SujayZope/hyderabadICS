package lk.restaurant.Repository;

import lk.restaurant.Model.TempData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempDataRepository extends JpaRepository<TempData,Integer> {
}
