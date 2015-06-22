package controllers.partner;

import java.util.Locale;
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
public class PartnerList {

    private static final Logger logger = Logger.getLogger(PartnerList.class);

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"partnerList"})
    public ModelAndView createFreelancer(Locale locale) {

        ModelAndView mav = null;

        try {

            mav = new ModelAndView("partner/partnerList");

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
