package com.userdetail.account.view;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.userdetail.account.R;
import com.userdetail.account.presenter.AccountPresenterImpl;
import com.userdetail.account.utils.AppConstant;
import com.userdetail.account.view.IWidgetView;

import java.util.ArrayList;
import java.util.List;

/**
 * WidgetDataProvider acts as the adapter for the collection view widget,
 * providing RemoteViews to the widget in the getViewAt method.
 */
public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory, IWidgetView {

    private AccountPresenterImpl presenter;
    private List<String> mAccounts = new ArrayList<>();
    private Context mContext = null;

    public WidgetDataProvider(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        presenter = new AccountPresenterImpl(this);
        presenter.getAccountDetails(mContext, AppConstant.ALL_ACCOUNTS, AppConstant.ALL_ACCOUNTS);
    }

    @Override
    public int getCount() {
        return mAccounts.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews view = new RemoteViews(mContext.getPackageName(),
                android.R.layout.simple_list_item_1);
        view.setTextViewText(android.R.id.text1, setAccountName(position));
        return view;
    }

    private String setAccountName(int position) {
        return String.format(mContext.getString(R.string.text_format), mContext.getString(R.string.text_account_name), mAccounts.get(position));
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private void initData(List<String> accountList) {
        mAccounts.clear();
        mAccounts.addAll(accountList);
    }

    @Override
    public void updateWidget(ArrayList<String> value) {
        initData(value);
    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

}
