package com.e2edour.web.p.controller;


import com.e2edour.app.facade.TopicsFacade;
import com.e2edour.app.facade.bean.CheckedTopicsBO;
import com.e2edour.common.utils.XmlUtil;
import com.e2edour.web.p.common.WebConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.e2edour.common.bean.Page;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopicsController {
    @Autowired
    private TopicsFacade topicsFacade;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"getTopics/{type}/{pageNo}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getTextTopics(Model model,@PathVariable String type,@PathVariable String pageNo) {
        CheckedTopicsBO bo = new CheckedTopicsBO();
        bo.setType(type);
        Page page = new Page();
        page.setCurrent(Integer.parseInt(pageNo));
        page.setRowCount(WebConstants.PAGESIZE);
        Page<CheckedTopicsBO> bos = topicsFacade.queryCheckedTopicsForPage(page,bo);
        model.addAttribute("topics", bos);
        return "text_topics";
    }
}

