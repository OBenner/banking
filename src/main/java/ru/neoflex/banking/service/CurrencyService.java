package ru.neoflex.banking.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import jdk.nashorn.api.scripting.URLReader;
import org.springframework.stereotype.Service;
import ru.neoflex.banking.model.Currency;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    public List<Currency> getCurrencyFromApi(){
        List<Currency> currencyList = new ArrayList<>();
        ObjectReader mapper = new ObjectMapper().readerFor(JsonNode.class);
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readValue(new URLReader(new URL("https://www.cbr-xml-daily.ru/daily_json.js")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        JsonNode nameNode = rootNode.get("Valute");
        for (JsonNode child : nameNode) {
            Currency currency = new Currency();
            currency.setСode(child.get("CharCode").asText());
            currency.setValue(child.get("Value").doubleValue());
            currency.setNominal(child.get("Nominal").asLong());
            currency.setName(child.get("Name").textValue());

            currencyList.add(currency);

        }

        return currencyList;
    }



}
