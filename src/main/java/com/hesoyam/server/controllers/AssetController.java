package com.hesoyam.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hesoyam.server.models.Bittrex;
import com.hesoyam.server.repositories.BittrexRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bittrex")
public class AssetController {
    @Autowired
    private final BittrexRepository repository;

    public AssetController(BittrexRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Bittrex getByid(@PathVariable("id") ObjectId id){
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/startDate/{symbol}", method = RequestMethod.GET)
    public int getStartDate(@PathVariable("symbol") String symbol) throws JsonProcessingException {
        Bittrex b = repository.findTopBySymbolOrderByDateAsc(symbol);

        return Integer.valueOf(b.getDate());
    }

    @RequestMapping(value = "/endDate/{symbol}", method = RequestMethod.GET)
    public int getEndDate(@PathVariable("symbol") String symbol) throws JsonProcessingException {
        Bittrex b = repository.findTopBySymbolOrderByDateDesc(symbol);

        return Integer.valueOf(b.getDate());
    }

    @RequestMapping("/symbols")
    public List<String> getPossibleSymbols() throws JsonProcessingException {
        List<String> symbol = repository.getPossibleSymbols();

        return symbol;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Bittrex> getAssetBySymbol(String symbol) throws JsonProcessingException{
        return repository.findDistinctBittrexBySymbol(symbol);
    }

    @RequestMapping(value = "/{symbol}/{start_date}/{end_date}", method = RequestMethod.GET)
    public List<Bittrex> getAssetByDate(@PathVariable("symbol") String symbol,
                                       @PathVariable("start_date") int startDate,
                                       @PathVariable("end_date") int endDate) throws JsonProcessingException {
        return repository.findDistinctBittrexBySymbolAndDateBetween(symbol, startDate, endDate);
    }
}
