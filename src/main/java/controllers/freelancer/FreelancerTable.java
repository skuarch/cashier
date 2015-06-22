package controllers.freelancer;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.beans.Freelancer;
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
public class FreelancerTable extends BaseController {

    private static final Logger logger = Logger.getLogger(FreelancerTable.class);

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = {"freelancerTable"})
    public ModelAndView freelancerTable(Locale locale) {

        ModelAndView mav = null;
        String json;
        HashMap<String,Object> parameters = new HashMap<>();
        Freelancer[] freelancers;

        try {
            
            parameters.put("key", "value");
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_FREELANCER_GET_LIST
            );
            
            freelancers = new Gson().fromJson(json, Freelancer[].class);            
            mav = new ModelAndView("freelancer/freelancerTable");
            mav.addObject("freelancers", freelancers);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
