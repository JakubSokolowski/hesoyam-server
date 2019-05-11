package com.hesoyam.server.controllers;

import com.hesoyam.server.models.Bittrex;
import com.hesoyam.server.repositories.BittrexRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bittrex")
public class BittrexController {
    @Autowired
    private final BittrexRepository repository;

    public BittrexController(BittrexRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Bittrex getByid(@PathVariable("id") ObjectId id)
    {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{symbol}", method = RequestMethod.GET)
    public List<Bittrex> getCurrencyBySymbol(@PathVariable("symbol") String symbol)
    {
        return repository.findBySymbol(symbol, new Sort("date"));
    }

    @RequestMapping(value = "/{symbol}/{start_date}/{end_date}", method = RequestMethod.GET)
    public List<Bittrex> getCurrencyByDate(@PathVariable("symbol") String symbol, @PathVariable("start_date") String start_date,
                                           @PathVariable("end_date") String end_date)
    {
        return repository.findBySymbolAndDateBetween(symbol, start_date, end_date, new Sort("date"));
    }
}
