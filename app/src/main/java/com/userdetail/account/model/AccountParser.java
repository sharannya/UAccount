package com.userdetail.account.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

/**
 * Class to parse account object
 */
public class AccountParser {
    /**
     * Converts response and stores in AccountDetailModel object
     *
     * @param response responseString from the json file
     */
    public AccountModel setAccountDetailModel(String response) throws JsonParseException {
        Gson gson = new GsonBuilder().create();
        AccountModel model = gson.fromJson(response, AccountModel.class);
        return model;


    }

}
