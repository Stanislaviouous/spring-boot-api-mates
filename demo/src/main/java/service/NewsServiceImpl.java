package service;

import model.News;
import org.springframework.beans.factory.annotation.Autowired;
import repository.NewsRepository;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository repository;

    @Override
    public void save(News news) {
        repository.save(news);
    }

    @Override
    public boolean isExist(String newTitle) {
        List<News> news = repository.findAll();
        for (News n: news){
            if (n.getTitle().equals(newTitle)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return null;
    }
}
