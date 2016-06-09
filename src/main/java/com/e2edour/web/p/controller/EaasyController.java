package com.e2edour.web.p.controller;


import com.e2edour.app.facade.EaasyManagerFacade;
import com.e2edour.app.facade.TopicsFacade;
import com.e2edour.app.facade.bean.CheckedEaasyBO;
import com.e2edour.app.facade.bean.CheckedTopicsBO;
import com.e2edour.app.facade.bean.NavigationBO;
import com.e2edour.common.bean.Page;
import com.e2edour.web.p.common.WebConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.e2edour.web.p.common.WebConstants.CACHE_NAVIGATIONS;

@Controller
public class EaasyController {

    @Autowired
    private EaasyManagerFacade eaasyManagerFacade;

    @RequestMapping(value = {"getEaasy/{pageNo}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getEaasys(Model model, @PathVariable String pageNo) {
        Page page = new Page();
        page.setCurrent(Integer.parseInt(pageNo));
        page.setRowCount(10);
        Page<CheckedEaasyBO> eaasys = eaasyManagerFacade.queryCheckedEaasyForPage(page, new CheckedEaasyBO());
        model.addAttribute("eaasy", eaasys);
        return "eaasy_list";
    }

    @RequestMapping(value = {"getEaasy/view/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getOneEaasy(Model model, @PathVariable String id) {
        CheckedEaasyBO checkedEaasyBO = eaasyManagerFacade.queryCheckedEaasyForOne(id);
        model.addAttribute("eaasyDetail",checkedEaasyBO);
        // TODO: 2016/6/9  
        List<NavigationBO> cacheNavigations = CACHE_NAVIGATIONS.get(WebConstants.NAVIGATIONS);
        model.addAttribute(WebConstants.NAVIGATIONS, cacheNavigations);
        return "eaasy_detail";
    }
}

