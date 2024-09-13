package lk.restaurant.Service.Impl;

import lk.restaurant.Model.Tax;
import lk.restaurant.Service.TaxService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaxServiceImpl implements TaxService {
    @Override
    public Optional<Tax> getAllTaxes(Integer itemCode) throws Exception {

        return Optional.empty();
    }
}
