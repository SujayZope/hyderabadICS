package lk.restaurant.Repository;

import lk.restaurant.Model.M_Restaurant;
import lk.restaurant.Repository.Custom.RestaurantRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<M_Restaurant,Integer>, RestaurantRepositoryCustom {
}
