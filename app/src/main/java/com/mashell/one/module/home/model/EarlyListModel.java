package com.mashell.one.module.home.model;

import com.mashell.one.C;
import com.mashell.one.module.home.contract.EarlyListContract;
import com.mashell.one.module.main.model.Month;
import com.mashell.one.util.Utils;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mashell on 16/11/30.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class EarlyListModel implements EarlyListContract.IEarlyListModel {
    @Override
    public List<Month> getEarlyMonth(int type) {
        switch (type) {
            case C.TYPE_ONE:

            case C.TYPE_TAB_ESSAY:

            case C.TYPE_TAB_QUESTION:
                return Utils.getMonthList(Calendar.getInstance(),C.LONG_TYPE);

            case C.TYPE_TAB_SERIAL:

            case C.TYPE_MUSIC:
                return Utils.getMonthList(Calendar.getInstance(),C.SHORT_TYPE);

            default:
                return null;
        }

    }
}
