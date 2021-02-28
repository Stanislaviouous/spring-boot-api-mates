package api;


import model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.NewsService;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping(value = "/new")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }
}
