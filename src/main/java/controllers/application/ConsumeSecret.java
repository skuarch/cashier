package controllers.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.PersonBasicInformation;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import model.util.PersonBasicInformationUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class ConsumeSecret extends BaseController {

    private static final Logger logger = Logger.getLogger(ConsumeSecret.class);

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;

    //==========================================================================
    @RequestMapping(value = {"consume/secret", "consumeSecret"}, method = RequestMethod.POST)
    public ModelAndView charge(
            @RequestParam("secret") String secret,
            @RequestParam("amount") BigDecimal amount,
            HttpServletResponse response,            
            Locale locale
    ) {

        ModelAndView mav = getModelAndViewJson();
        JSONObject jsono = null;
        HashMap parameters;
        PersonBasicInformation pbi;
        String json;

        try {
            
            //basic configuration
            setHeaderNoChache(response);

            //validations
            if (secret.length() < 8 || secret.length() > 8) {
                jsono = new JSONObject();
                jsono.put("charged", false);
                mav.addObject("json", jsono.toString());
                return mav;
            }

            if (amount.intValue() < 1 || amount.intValue() > 10000) {
                jsono = new JSONObject();
                jsono.put("charged", false);
                mav.addObject("json", jsono.toString());
                return mav;
            }
            
            //get the id from session
            pbi = PersonBasicInformationUtil.getPersonBasicInformation(session);                                
            
            //create parameters
            parameters = new HashMap();
            parameters.put("secret", secret);
            parameters.put("amount", amount);
            parameters.put("cashierId", pbi.getId());
            
            json = RestPostClient.sendReceive(
                    parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CASHIER_CONSUME_SECRET);
            
            jsono = new JSONObject(json);            
            mav.addObject("json", jsono.toString());
            return mav;

        } catch (Exception e) {
            logger.error("authentication", e);
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;
    }

}
