package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.Master_GroupDTO;
import lk.restaurant.Model.M_Group_Master;
import lk.restaurant.Repository.Master_Group_Repository;
import lk.restaurant.Service.Master_GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Master_GroupServiceImpl implements Master_GroupService {

    @Autowired
    Master_Group_Repository master_group_repository;

    @Override
    public List<Master_GroupDTO> getAll(Integer id, Integer mid, Integer fid) throws Exception {
        List<M_Group_Master> values=master_group_repository.getAllNames(id,mid,fid);
        List<Integer>demo=new ArrayList<>();
        ArrayList<Master_GroupDTO>groups=new ArrayList<>();
        for(M_Group_Master q:values){
            if(!demo.contains(q.getMaster_no())){
                demo.add(q.getMaster_no());
                groups.add(new Master_GroupDTO(q.getMaster_no(),q.getMaster_f_no(),q.getMaster_m_no(),q.getMaster_name()));
            }
        }
        return groups;
    }
}
