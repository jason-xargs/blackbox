package top.xyloto.blackbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xyloto.blackbox.service.SmokerService;
import top.xyloto.blackbox.util.TimeUtil;
import top.xyloto.blackbox.vo.Result;

import java.util.List;

/**
 * @author zhaocong05
 * @createTime 2017-09-18
 * @description Smoker
 */
@Controller
public class Smoker {

    @Autowired
    private SmokerService smokerService;

    private static final int MAX_PER_DAY = 15;
    private static final String PERMISSION_DENIED_MAX_PER_DAY = "Permission Denied : Quantity Is %s, Greater Than Max Per Day " + MAX_PER_DAY;
    private static final long MIN_INTERVAL = 60; // minute
    private static final String PERMISSION_DENIED_MIN_INTERVAL = "Permission Denied : Interval Is %s, Less Than Min Interval " + MIN_INTERVAL;

    @RequestMapping(value = "/smokers", method = RequestMethod.GET)
    public String smokers(Model model) {

        List<String> content = smokerService.history();
        try {
            model.addAttribute("result", new Result<List<String>>(true).setContent(content).setMessage(this.getMessage(content)));
        } catch (Exception e) {
            model.addAttribute("result", new Result(false, e.getMessage()));
        }
        return "smokers";
    }

    private String getMessage(List<String> content) {
        String message = null;
        if (CollectionUtils.isEmpty(content))
            return message;
        message = content.size() > MAX_PER_DAY ? String.format(PERMISSION_DENIED_MAX_PER_DAY, content.size()) : null;
        if (StringUtils.isEmpty(message)) {
            String last = content.get(0);
            message = TimeUtil.getIntervalMin(last) <= MIN_INTERVAL ? String.format(PERMISSION_DENIED_MIN_INTERVAL, TimeUtil.getIntervalMin(last)) : null;
        }
        return message;
    }

    @RequestMapping(value = "/addOne")
    @ResponseBody
    public Result addOne() {
        try {
            smokerService.addOne();
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true);
    }

}
