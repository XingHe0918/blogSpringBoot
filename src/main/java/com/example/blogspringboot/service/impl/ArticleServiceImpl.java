package com.example.blogspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blogspringboot.mapper.ArticleMapper;
import com.example.blogspringboot.model.bean.Article;
import com.example.blogspringboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int addArticle(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public List<Article> getArticleList() {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","uid","title","datetime","is_open");
        return articleMapper.selectList(queryWrapper);
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.selectById(id);
    }


}
