package com.userdetail.account.presenter;

import android.content.Context;

import com.userdetail.account.model.Account;
import com.userdetail.account.model.AccountModel;
import com.userdetail.account.utils.Response;
import com.userdetail.account.view.IAccountView;
import com.userdetail.account.view.IWidgetView;

import java.util.ArrayList;
import java.util.List;


/**
 * Class is offered to VIEW,MODEL to communicate with PRESENTER
 */
public class AccountPresenterImpl implements IAccountPresenter {

    private AccountModel model;
    private IAccountView view;
    private IWidgetView iWiew;

    public AccountPresenterImpl(IAccountView view) {
        model = new AccountModel(this);
        this.view = view;
    }

    public AccountPresenterImpl(IWidgetView iView) {
        model = new AccountModel(this);
        this.iWiew = iView;
    }

    @Override
    public void getAccountDetails(Context context, int accountType, int isWidgetData) {
        model.fetchDetails(context, accountType, isWidgetData);
    }

    @Override
    public void onTaskCompleted(List<Account> result, Response responseObject, int isWidgetData) {

        switch (isWidgetData) {
            case 0:
                iWiew.updateWidget(setWidgetData(result));
                break;
            case 1:
                if (result != null) {
                    view.onResponseSuccess(result);
                } else
                    view.onResponseFailure(responseObject);
                break;
        }

    }

    private ArrayList<String> setWidgetData(List<Account> result) {
        ArrayList<String> accountNoList = new ArrayList<String>();
        for (int i = 0; i < result.size(); i++) {
            accountNoList.add(result.get(i).getAccountNumber());
        }
        return accountNoList;
    }
}
