package ecnu.testing.meethere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends BaseService<NewsService> implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
}
