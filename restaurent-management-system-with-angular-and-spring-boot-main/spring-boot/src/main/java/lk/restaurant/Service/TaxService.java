package lk.restaurant.Service;

import lk.restaurant.Model.Tax;

import java.util.Optional;

public interface TaxService {

    public Optional<Tax> getAllTaxes(Integer itemCode)throws Exception;
}
