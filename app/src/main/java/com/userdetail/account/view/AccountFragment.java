package com.userdetail.account.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.userdetail.account.R;
import com.userdetail.account.adapter.AccountDetailAdapter;
import com.userdetail.account.model.Account;
import com.userdetail.account.presenter.AccountPresenterImpl;
import com.userdetail.account.utils.AppConstant;
import com.userdetail.account.utils.Response;

import java.util.List;

/**
 * A fragment representing account details
 */
public class AccountFragment extends Fragment implements IAccountView {

    private AccountPresenterImpl presenter;
    private RecyclerView mAccountRecyclerView;
    private TextView mAccountEmptyTextView;
    private int accountSelectionIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AccountPresenterImpl(this);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            accountSelectionIndex = bundle.getInt(AppConstant.INDEX, AppConstant.ALL_ACCOUNTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_list, container, false);
        mAccountRecyclerView = (RecyclerView) view.findViewById(R.id.rv_Account_List);
        mAccountEmptyTextView = (TextView) view.findViewById(R.id.tv_no_list_error);
        LinearLayoutManager verticalLayoutManager
                = new LinearLayoutManager(getActivity());
        mAccountRecyclerView.setLayoutManager(verticalLayoutManager);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getAccountDetails(getActivity(), accountSelectionIndex, AppConstant.ACTIVE_ACCOUNTS);
    }

    @Override
    public void onResponseSuccess(List<Account> accountList) {
        if (accountList != null) {
            setDataToView(accountList);
        }
    }


    /**
     * Method is used to set data to view
     *
     * @param accountList account detail list to be displayed to customer
     */
    private void setDataToView(List<Account> accountList) {
        if (accountList != null) {
            AccountDetailAdapter accountDetailAdapter = new AccountDetailAdapter(getActivity(), accountList);
            mAccountRecyclerView.setAdapter(accountDetailAdapter);
            mAccountEmptyTextView.setVisibility(View.GONE);
            mAccountRecyclerView.setVisibility(View.VISIBLE);
        } else {
            mAccountEmptyTextView.setVisibility(View.VISIBLE);
            mAccountRecyclerView.setVisibility(View.GONE);
        }
    }

    /**
     * Metthod called data loading issue occur
     * @param respErrorMsg
     */
    @Override
    public void onResponseFailure(Response respErrorMsg) {
        mAccountEmptyTextView.setVisibility(View.VISIBLE);
        mAccountEmptyTextView.setText(respErrorMsg.getResponseMsg());
        mAccountRecyclerView.setVisibility(View.GONE);
    }
}
