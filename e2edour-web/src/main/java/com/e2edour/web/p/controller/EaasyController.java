package com.e2edour.web.p.controller;


import com.e2edour.app.facade.EaasyManagerFacade;
import com.e2edour.app.facade.TopicsFacade;
import com.e2edour.app.facade.bean.CheckedEaasyBO;
import com.e2edour.app.facade.bean.CheckedTopicsBO;
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

@Controller
public class EaasyController {

    @Autowired
    private EaasyManagerFacade eaasyManagerFacade;

    @RequestMapping(value = {"getEaasy/{pageNo}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getTextTopics(Model model,@PathVariable String pageNo) {
        Page page = new Page();
        page.setCurrent(Integer.parseInt(pageNo));
        page.setRowCount(1);
        Page<CheckedEaasyBO> eaasys = eaasyManagerFacade.queryCheckedEaasyForPage(page,new CheckedEaasyBO());
        model.addAttribute("eaasy", eaasys);
        return "eaasy_detail";
    }
}

