package com.e2edour.web.p.common;

import com.e2edour.app.facade.bean.NavigationBO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by King on 2015/9/13.
 */
public class WebConstants {

    public final static String LOGIN = "account.Login";

    public final static String NAVIGATIONS = "navigations";

    public final static int PAGESIZE = 20;

    public final static Map<String, List<NavigationBO>> CACHE_NAVIGATIONS= new HashMap<String, List<NavigationBO>>();


}
