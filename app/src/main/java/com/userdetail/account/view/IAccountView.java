package com.userdetail.account.view;

import com.userdetail.account.model.Account;
import com.userdetail.account.utils.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * CBase Interface to VIEW to communicate with layers
 */
public interface IAccountView {
    /**
     * notify ui on response success
     *
     * @param accountList account object list for View layer
     */
    void onResponseSuccess(List<Account> accountList);

    /**
     * notify ui on response failure
     */
    void onResponseFailure(Response responseCode);

}
