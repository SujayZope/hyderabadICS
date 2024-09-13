package lk.restaurant.Repository;

import lk.restaurant.Model.Front_kot_bot_main;
import lk.restaurant.Repository.Custom.TableCloseCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableCloseRepository extends JpaRepository<Front_kot_bot_main,Integer>, TableCloseCustom {
}
