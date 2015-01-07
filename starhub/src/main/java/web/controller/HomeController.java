package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.BannerService;
import service.TabService;
import domain.Banner;
import domain.Tab;

@RequestMapping("/")
@Controller
public class HomeController {
	final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BannerService bannerService;
	@Autowired
	private TabService tabService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model uiModel) {
		logger.info("Listing banners");
		List<Banner> banners = bannerService.findAll();
		uiModel.addAttribute("banners", banners);

		logger.info("Listing tabs");
		List<Tab> tabs = tabService.findAll();
		uiModel.addAttribute("tabs", tabs);

		return "home/index";
	}
}
