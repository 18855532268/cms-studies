package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@Api(description = "信息管理")
public class ArticleController {
    @Autowired
    private IArticleService articleService;
    @PostMapping("/add")
    @ApiOperation(value = "新增信息" ,notes = "category.code  category.name不需要输入")
    public Message addArticle(Article article){
        articleService.addArticle(article);
        return MessageUtil.success();
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除信息")
    @ApiImplicitParam(value = "信息id",name = "id",paramType = "query",dataType = "int",required=true)
    public Message deleteById(int id){
        articleService.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("/selectById")
    @ApiOperation(value = "根据id查询信息")
    @ApiImplicitParam(value = "信息id",name = "id",paramType = "query",dataType = "int",required=true)
    public Message<Article> selectById(int id){
        Article article = articleService.findById(id);
        return MessageUtil.success(article);
    }

}
