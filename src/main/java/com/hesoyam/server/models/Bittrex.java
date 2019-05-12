package com.hesoyam.server.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Bittrex {
    @Id
    private ObjectId _id;
    private double date;
    private String symbol;
    private double open;
    private double high;
    private double low;
    private double close;

    public Bittrex()
    {
    }

    public Bittrex(ObjectId id, double date, String symbol, double open,
                    double high, double low, double close)
    {
        this._id = id;
        this.date = date;
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public String getId(){
        return _id.toHexString();
    }

    public void setId(ObjectId id){
        this._id = id;
    }

    public String getDate(){
        return String.valueOf(date);
    }

    public void setDate(double date){
        this.date = date;
    }

    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getOpen(){
        return String.valueOf(open);
    }

    public void setOpen(double open){
        this.open = open;
    }

    public String getHigh(){
        return String.valueOf(high);
    }

    public void setHigh(double high){
        this.high = high;
    }

    public String getLow(){
        return String.valueOf(low);
    }

    public void setLow(double low){
        this.low = low;
    }

    public String getClose(){
        return String.valueOf(close);
    }

    public void setClose(double close){
        this.close = close;
    }
}
