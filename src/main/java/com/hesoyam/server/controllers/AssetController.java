package com.hesoyam.server.controllers;

import com.hesoyam.server.models.Bittrex;
import com.hesoyam.server.repositories.BittrexRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET)
    public List<Map<String, Object>> getAssetBySymbol(@RequestParam(value="symbol") String symbol){
        List<Bittrex> data = repository.findBySymbol(symbol, new Sort("date"));
        List<Map<String, Object>> response = new ArrayList<>();
        Map<String, Object>element = new HashMap<>();

        for(Bittrex elem : data)
        {
            element.put("d", elem.getDate());
            element.put("o", elem.getOpen());
            element.put("h", elem.getHigh());
            element.put("l", elem.getLow());
            element.put("c", elem.getClose());

            response.add(element);
        }

        return response;
    }

    @RequestMapping(value = "/{symbol}/{start_date}/{end_date}", method = RequestMethod.GET)
    public List<Map<String, Object>> getAssetByDate(@PathVariable("symbol") String symbol,
                                                    @PathVariable("start_date") double start_date,
                                                    @PathVariable("end_date") double end_date){
        List<Bittrex> data =  repository.findBySymbolAndDateBetween(symbol, start_date, end_date,
                                new Sort("date"));
        List<Map<String, Object>> response = new ArrayList<>();
        Map<String, Object>element = new HashMap<>();

        for(Bittrex elem : data)
        {
            element.put("d", elem.getDate());
            element.put("o", elem.getOpen());
            element.put("h", elem.getHigh());
            element.put("l", elem.getLow());
            element.put("c", elem.getClose());

            response.add(element);
        }

        return response;
    }
}
