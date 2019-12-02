package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
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

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(description = "/栏目管理")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("添加栏目")
    @PostMapping("/add")
    public Message addCategory(Category category) {
        categoryService.saveOrUpdateCategory(category);
        return MessageUtil.success();
    }
    @ApiOperation("查询所有栏目")
    @GetMapping("/findAll")
    public Message<List<Category>> findAll(List list){
        List<Category> categoryList = categoryService.findAll();
        return MessageUtil.success(categoryList);
    }
    @ApiOperation("根据id删除栏目")
    @GetMapping("/deleteById")
    public Message deleteById(int id){
        categoryService.deleteById(id);
        return MessageUtil.success();
    }
    @ApiOperation("根据id查询栏目")
    @GetMapping("/findById")
    @ApiImplicitParam(name = "id",value = "栏目id",paramType = "query",dataType = "int",required = true)
    public Message<Category> findById(int id){
        Category category = categoryService.findById(id);
        return MessageUtil.success(category);
    }
    @ApiOperation("更新栏目")
    @PostMapping("/update")
    public Message update(Category category){
        categoryService.saveOrUpdateCategory(category);
        return MessageUtil.success();
    }
}
