package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArcetleDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private IArcetleDao arcetleDao;

    @Override
    public void addArticle(Article article) throws CustomerException {
        if (article == null){
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        }
        article.setClickTimes(0);
        article.setPublishDate(new Date());
        arcetleDao.save(article);
    }

    @Override
    public void deleteById(int id) throws CustomerException {
        arcetleDao.deleteById(id);

    }

    @Override
    public Article findById(int id) throws CustomerException {
        return arcetleDao.queryById(id);
    }
}
