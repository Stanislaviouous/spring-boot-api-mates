package job;

import model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.NewsService;

import java.io.IOException;

@Component
public class TaskParse {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 10000)
    public void parseNewsNews(){
        String url = "https://news.ycombinator.com/";

        try {
            Document doc = (Document) Jsoup.connect(url).userAgent("Google Chrome").timeout(5000).referrer("https://google.com").get();
            Elements news = doc.getElementsByClass("storylink");
            for (Element el: news){
                String title = el.ownText();
                if(!newsService.isExist((title))) {
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
