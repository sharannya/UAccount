/**
 * Parent class for holding response array object
 */
package com.userdetail.account.model;

import android.content.Context;

import com.google.gson.JsonParseException;
import com.userdetail.account.R;
import com.userdetail.account.presenter.AccountPresenterImpl;
import com.userdetail.account.utils.Logger;
import com.userdetail.account.utils.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AccountModel {

    private List<Account> accounts = null;
    private String failedAccountTypes;
    private String returnCode;
    private AccountPresenterImpl presenter = null;

    public AccountModel(AccountPresenterImpl presenter) {
        this.presenter = presenter;
    }

    public List<Account> getAccountList() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getFailedAccountTypes() {
        return failedAccountTypes;
    }

    public void setFailedAccountTypes(String failedAccountTypes) {
        this.failedAccountTypes = failedAccountTypes;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Method is used to fetch data from json file
     *
     * @param context context from view
     * @return model Account object
     */
    public void fetchDetails(Context context, int accountType, int isWidgetData) {
        AccountModel model = null;
        List<Account> accountList = null;
        String response = "";
        Response responseObject = null;
        try {
            AccountParser accountParser = new AccountParser();
            response = readJson(context);
            model = accountParser.setAccountDetailModel(response);
            if (model != null) {
                if (accountType == 1) {
                    accountList = getActiveAccountData(model);
                } else {
                    accountList = model.getAccountList();
                }
            }
        } catch (JsonParseException e) {
            Logger.e(e.getMessage());
            responseObject.setResponseMsg("There was a retreiving data.Please try again after some time.");
        } catch (IOException e) {
            Logger.e(e.getMessage());
            responseObject.setResponseMsg("Unable to fetch data");
        }
        if (model != null && accountType == 1) {
            getActiveAccountData(model);
        }
        if (presenter != null) {
            presenter.onTaskCompleted(accountList, responseObject, isWidgetData);
        }

    }

    /**
     * Method is used to get details of the active mAccountList
     *
     * @param model model object used to
     * @return active account list
     */
    private List<Account> getActiveAccountData(AccountModel model) {
        List<Account> accountList = new ArrayList<Account>();
        int accountListSize = model.getAccountList().size();
        for (int i = 0; i < accountListSize; i++) {
            if (model.getAccountList().get(i).getIsVisible().equalsIgnoreCase("true"))
                accountList.add(model.getAccountList().get(i));
        }
        return accountList;
    }

    /**
     * Method is used to get details of the active mAccountList
     *
     * @param model model object used to
     * @return active account list
     */
    private List<String> getActiveAccountName(AccountModel model) {
        List<String> accountList = new ArrayList<String>();
        int accountListSize = model.getAccountList().size();
        for (int i = 0; i < accountListSize; i++) {
            if (model.getAccountList().get(i).getIsVisible().equalsIgnoreCase("true"))
                accountList.add(model.getAccountList().get(i).getAccountName());
        }
        return accountList;
    }

    /**
     * Read json object
     *
     * @param context context from the view layer
     * @return json string object
     */
    private String readJson(Context context) throws IOException {
        String response = "";
        InputStream is = context.getResources().openRawResource(R.raw.json);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            response = writer.toString();
        } catch (UnsupportedEncodingException e) {
            Logger.e(e.getMessage());
        } catch (IOException e) {
            Logger.e(e.getMessage());
        } finally {
            is.close();
        }

        return response;
    }
}