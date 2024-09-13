package lk.restaurant.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_group_major")
public class M_Group_Major {

    @Id
    private Integer M_no;
    private String M_name;

}
