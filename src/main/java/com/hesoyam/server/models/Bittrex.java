package com.hesoyam.server.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Bittrex {
    @Id
    private ObjectId _id;
    private String date;
    private String symbol;
    private double open;
    private double high;
    private double low;
    private double close;

    public Bittrex()
    {
    }

    public Bittrex(ObjectId id, String date_, String symbol_, double open_,
                    double high_, double low_, double close_)
    {
        this._id = id;
        this.date = date_;
        this.symbol = symbol_;
        this.open = open_;
        this.high = high_;
        this.low = low_;
        this.close = close_;
    }

    public String get_id()
    {
        return _id.toHexString();
    }

    public void set_id(ObjectId id)
    {
        this._id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date_)
    {
        this.date = date_;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol_)
    {
        this.symbol = symbol_;
    }

    public String getOpen()
    {
        return String.valueOf(open);
    }

    public void setOpen(double open_)
    {
        this.open = open_;
    }

    public String getHigh()
    {
        return String.valueOf(high);
    }

    public void setHigh(double high_)
    {
        this.high = high_;
    }

    public String getLow()
    {
        return String.valueOf(low);
    }

    public void setLow(double low_)
    {
        this.low = low_;
    }

    public String getClose()
    {
        return String.valueOf(close);
    }

    public void setClose(double close_)
    {
        this.close = close_;
    }
}
