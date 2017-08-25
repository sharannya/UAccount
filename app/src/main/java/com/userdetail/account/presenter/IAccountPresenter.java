package com.userdetail.account.presenter;

import android.content.Context;

import com.userdetail.account.model.Account;
import com.userdetail.account.utils.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Interface to PRESENTER to communicate with layers
 */
public interface IAccountPresenter {

    //used to fetch details
    void getAccountDetails(Context context,int accountType,int isWidgetData);

    //called when fetch accountDetails is completed
    void onTaskCompleted(List<Account> accountList,Response responseObject, int isWidgetData);

}
