package com.e2edour.web.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e2edour.web.p.common.MenuTranCodes;

@Controller
public class AdvertisementController
{
  @RequestMapping(value={"getAdvertisement"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  public String getAdvertisement(Model model)
  {
    model.addAttribute("tranCode", MenuTranCodes.TRANCODE_ADVS.getTranCode());
    model.addAttribute("central", "advertisement.html");
    return "main";
  }
}
