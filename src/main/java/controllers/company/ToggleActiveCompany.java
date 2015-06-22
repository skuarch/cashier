package controllers.company;

import controllers.affiliate.*;
import controllers.freelancer.*;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch-lap
 */
@Controller
public class ToggleActiveCompany extends BaseController {
    
    private static final Logger logger = Logger.getLogger(ToggleActiveCompany.class);

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = {"toggleActiveCompany"})
    public ModelAndView toggleActiveCompany(@RequestParam int companyId, Locale locale) {

        ModelAndView mav = null;
        String json;
        HashMap<String,Object> parameters;     
        JSONObject jsono;

        try {            
            
            parameters = ApplicationUtil.createParameters(companyId);
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_COMPANY_TOGGLE_ACTIVE
            );                       
            
            jsono = new JSONObject(json);            
            mav = super.getModelAndViewJson();            
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
