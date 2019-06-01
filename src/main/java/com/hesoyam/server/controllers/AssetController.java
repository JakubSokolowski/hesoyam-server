package com.hesoyam.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hesoyam.server.models.Bittrex;
import com.hesoyam.server.repositories.BittrexRepository;
import com.hesoyam.server.jsonModules.BittrexJsonModule;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<String> getAssetBySymbol(String symbol) throws JsonProcessingException{
        List<Bittrex> data = repository.findDistinctBittrexBySymbol(symbol);

        return serialize(data);
    }

    @RequestMapping(value = "/{symbol}/{start_date}/{end_date}", method = RequestMethod.GET)
    public List<String> getAssetByDate(@PathVariable("symbol") String symbol,
                                       @PathVariable("start_date") int startDate,
                                       @PathVariable("end_date") int endDate) throws JsonProcessingException {
        List<Bittrex> data =  repository.findDistinctBittrexBySymbolAndDateBetween(symbol, startDate, endDate);

        return serialize(data);
    }

    private List<String> serialize(List<Bittrex> data) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new BittrexJsonModule());
        List<String> response = new ArrayList<>();

        for(Bittrex b : data)
        {
            response.add(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(b));
        }
        return response;
    }
}
