package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VideoController {

    @GetMapping("/videos")
    public String index() {
        return "videos";
    }

    @GetMapping("/video/{id}")
    public String video(@PathVariable(name = "cid") String cid,
                        @PathVariable(name = "page") String page,
                        Model model) {
        model.addAttribute("cid", cid);
        model.addAttribute("page", page);
        return "video";
    }
}
