package com.e2edour.web.p.controller;

import com.e2edour.app.facade.WebPFacade;
import com.e2edour.app.facade.bean.NavigationBO;
import com.e2edour.web.p.common.WebConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.e2edour.web.p.common.WebConstants.CACHE_NAVIGATIONS;

@Controller
@RequestMapping({"/"})
public class IndexController {
    @Autowired
    private WebPFacade webPFacade;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="**/",method = {RequestMethod.GET})
    public String index(Model model) {
        List<NavigationBO> cacheNavigations = CACHE_NAVIGATIONS.get(WebConstants.NAVIGATIONS);
        if(null==cacheNavigations){
            cacheNavigations = webPFacade.getNavigations();
            CACHE_NAVIGATIONS.put(WebConstants.NAVIGATIONS,cacheNavigations);
        }
        model.addAttribute(WebConstants.NAVIGATIONS, cacheNavigations);
        return "index";
    }

}