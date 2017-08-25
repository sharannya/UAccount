package com.userdetail.account.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.userdetail.account.R;
import com.userdetail.account.model.Account;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Provide views to RecyclerView with account details
 */

public class AccountDetailAdapter extends RecyclerView.Adapter<AccountDetailAdapter.AccountDetailViewHolder> {

    private List<Account> mDataModel;
    private Context mContext;

    /**
     * Initialize the data of the Adapter.
     *
     * @param details model object containing the data to populate views to be used by RecyclerView.
     */
    public AccountDetailAdapter(Context context, List<Account> details) {
        this.mDataModel = details;
        this.mContext = context;
    }

    @Override
    public AccountDetailViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_account_detail, viewGroup, false);
        return new AccountDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AccountDetailViewHolder viewHolder, int position) {
        Account account = mDataModel.get(position);
        if (account != null) {
            viewHolder.tvIBanNo.setText(String.format(mContext.getString(R.string.text_format), mContext.getString(R.string.text_iban_header), account.getIban()));
            viewHolder.tvAccountBal.setText(setCurrencyFormat(account.getAccountBalanceInCents()));
            viewHolder.tvAccountName.setText(String.format(mContext.getString(R.string.text_format), mContext.getString(R.string.text_account_name), account.getAccountNumber()));

        }
    }

    /**
     * Method is used to set currency in format
     *
     * @param amount
     * @return
     */
    private String setCurrencyFormat(int amount) {
        String currencyText = "";
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        currencyText = String.format(mContext.getString(R.string.amount_format), mContext.getString(R.string.euro), formatter.format(amount));
        return currencyText;
    }

    @Override
    public int getItemCount() {
        if (mDataModel != null)
            return mDataModel.size();
        else
            return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    /*
          Method used to notify adapter for changes
         */
    public void notifyDataChanged(List<Account> accountList) {
        this.mDataModel = accountList;
        notifyDataSetChanged();
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    static class AccountDetailViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvIBanNo;
        private final TextView tvAccountBal;
        private final TextView tvAccountName;


        AccountDetailViewHolder(View view) {
            super(view);
            tvIBanNo = (TextView) view.findViewById(R.id.tv_iban);
            tvAccountBal = (TextView) view.findViewById(R.id.tv_account_balance);
            tvAccountName = (TextView) view.findViewById(R.id.tv_account_name);
        }
    }

}