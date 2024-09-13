package lk.restaurant.Repository;

import lk.restaurant.Model.M_Group_Major;
import lk.restaurant.Repository.Custom.Master_Group_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Master_Group_Repository extends JpaRepository<M_Group_Major,Long>, Master_Group_Custom {
}
