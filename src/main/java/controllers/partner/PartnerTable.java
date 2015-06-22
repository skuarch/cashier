package controllers.partner;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.beans.Freelancer;
import model.beans.Partner;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch-lap
 */
@Controller
public class PartnerTable extends BaseController {

    private static final Logger logger = Logger.getLogger(PartnerTable.class);

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = {"partnerTable"})
    public ModelAndView partnerTable(Locale locale) {

        ModelAndView mav = null;
        String json;
        HashMap<String,Object> parameters = new HashMap<>();
        Partner[] partners;

        try {
            
            parameters.put("key", "value");
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_PARTNER_GET_LIST
            );
            
            partners = new Gson().fromJson(json, Partner[].class);            
            mav = new ModelAndView("partner/partnerTable");
            mav.addObject("partners", partners);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
