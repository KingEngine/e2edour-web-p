package com.e2edour.web.p.controller;

import com.e2edour.app.facade.CustomerFacade;
import com.e2edour.app.facade.bean.CustomerBO;
import com.e2edour.common.bean.Constants;
import com.e2edour.common.bean.Response;
import com.e2edour.common.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 注册controller
 *
 * @author King
 */
@Controller
@RequestMapping("register/")
public class RegisterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerFacade customerFacade;

    /**
     * 页面初始化
     * @return
     */
    @RequestMapping(value = Constants.pagePre, method = {RequestMethod.GET, RequestMethod.POST})
    public String registerPre() {
        return "register";
    }

    /**
     * 数据添加
     * @param customerBO
     * @return
     */
    @RequestMapping(value = Constants.addData, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Response registerSubmit(CustomerBO customerBO) {
        //注册用户
        try {
            customerFacade.registerVIP(customerBO);
            return new Response(Constants.SUCCESS_CODE, Constants.SUCCESS_DESC);
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            return new Response(Constants.ERROR_CODE, e.getMessage());
        }
    }
}
