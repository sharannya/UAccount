package com.userdetail.account.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

import com.userdetail.account.view.WidgetDataProvider;

/**
 * WidgetService is the {@link android.widget.RemoteViewsService} that will return our RemoteViewsFactory
 */
public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new WidgetDataProvider(this);
    }
}
