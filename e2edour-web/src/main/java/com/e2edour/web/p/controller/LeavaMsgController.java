package com.e2edour.web.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e2edour.app.facade.ILeaveMsgService;
import com.e2edour.app.facade.bean.LeaveMsgBO;

@Controller
public class LeavaMsgController
{
  @Autowired
  private ILeaveMsgService leaveMsgServie;
  
  @RequestMapping(value={"addLeaveMsg"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public String addLeaveMsg(LeaveMsgBO bo)
  {
    this.leaveMsgServie.insert(bo);
    return "success";
  }
}

