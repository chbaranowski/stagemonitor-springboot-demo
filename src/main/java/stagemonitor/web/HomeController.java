package stagemonitor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stagemonitor.core.Review;
import stagemonitor.core.ReviewRepository;

@Controller
public class HomeController {

    @Autowired
    ReviewRepository reviewRepository;
    
    @RequestMapping("/")
    ModelAndView get() {
        Iterable<Review> reviews = reviewRepository.findAll();
        return new ModelAndView("index", "reviews", reviews);
    }
    
}
