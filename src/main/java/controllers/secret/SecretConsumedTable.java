package controllers.secret;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.CashierSecretConsumed;
import model.beans.PersonBasicInformation;
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
public class SecretConsumedTable extends BaseController {

    private static final Logger logger = Logger.getLogger(SecretConsumedTable.class);

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;

    //==========================================================================
    @RequestMapping(value = {"secretConsumedTable"})
    public ModelAndView partnerTable(Locale locale) {

        ModelAndView mav = null;
        String json;
        HashMap<String,Object> parameters = new HashMap<>();
        CashierSecretConsumed[] cashierSecretConsumeds;
        PersonBasicInformation personBasicInformation = null;

        try {
            
            personBasicInformation = (PersonBasicInformation) session.getAttribute("personBasicInformation");
            
            parameters.put("cashierId", personBasicInformation.getId());
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CASHIER_GET_CONSUMED_SECRETS
            );
            
            cashierSecretConsumeds = new Gson().fromJson(json, CashierSecretConsumed[].class);            
            mav = new ModelAndView("secret/secretConsumedTable");
            mav.addObject("cashierSecretConsumeds", cashierSecretConsumeds);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
