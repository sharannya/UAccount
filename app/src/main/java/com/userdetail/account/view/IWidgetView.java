package com.userdetail.account.view;

import java.util.ArrayList;

/**
 * CBase Interface to VIEW to communicate with layers
 */
public interface IWidgetView {

    /**
     * notify to update widget
     *
     * @param value
     */

    void updateWidget(ArrayList<String> value);

}
