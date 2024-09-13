package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.Family_GroupDTO;
import lk.restaurant.Model.M_Group_Family;
import lk.restaurant.Repository.Family_Group_Repository;
import lk.restaurant.Service.Family_GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Family_GroupServiceImpl implements Family_GroupService {

    @Autowired
    Family_Group_Repository family_group_repository;

    @Override
    public List<Family_GroupDTO> getAll(Integer id) throws Exception {
        List<M_Group_Family>values=family_group_repository.getAllNames(id);
        List<Integer>demo=new ArrayList<>();
        ArrayList<Family_GroupDTO>groups=new ArrayList<>();
        for(M_Group_Family q:values){
            if (!demo.contains(q.getF_no())){
                demo.add(q.getF_no());
                groups.add(new Family_GroupDTO(q.getF_no(),q.getF_M_no(),q.getF_name()));
            }
        }
        return groups;
    }
}
