package com.e2edour.web.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e2edour.app.facade.ISurpriseService;
import com.e2edour.app.facade.bean.SurpriseBO;
import com.e2edour.web.p.common.MenuTranCodes;

@Controller
public class SurpriseController
{
  @Autowired
  private ISurpriseService surpriseService;
  
  @RequestMapping(value={"getSurpriseIndex"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  public String getSurpriseIndex(Model model)
  {
    model.addAttribute("tranCode", MenuTranCodes.TRANCODE_SURPRISE.getTranCode());
    model.addAttribute("content", "surprise_index.html");
    model.addAttribute("central", "central_text.html");
    List<SurpriseBO> list = this.surpriseService.getSurprises();
    model.addAttribute("surprises", list);
    return "main";
  }
  
  @RequestMapping(value={"show"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  public String show(String url)
  {
    return "redirect:" + url;
  }
}
