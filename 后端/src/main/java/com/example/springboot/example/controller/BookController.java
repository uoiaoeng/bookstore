package com.example.springboot.example.controller;


import com.example.springboot.example.entity.Book;
import com.example.springboot.example.entity.User;
import com.example.springboot.example.service.BookService;
import com.example.springboot.example.service.UserService;
import com.example.springboot.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController  //  变成servlet
@RequestMapping("/book")
@Api(description = "书籍controller,访问的baseURL=http://localhost:8888/SpringBoot")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/pageByUsername")
    public Result pageByUsername(Integer pageNum,Integer pageSize,String username){
        Result result = new Result();
        result.setData(bookService.pageByUsername(pageNum,pageSize,username));
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getById")
    public Result getById(String id){
        Result result = new Result();
        Book bookExit = bookService.getById(id);
        if(bookExit!=null){
            result.success("获取成功");
            result.setData(bookExit);

            User user = userService.getById(bookExit.getUserId());
            bookExit.put("user", user);
        }else{
            result.fail("获取失败");
        }
        return result;
    }

    @ApiOperation(value = "增加记录")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody Book book){

        Result result = new Result();

//        //通过书名 去数据库查找一下是否有纪录
//        Book bookExit = bookService.getByName(book.getName());
        bookService.addOrUpdate(book);
        result.success("保存成功");
        return result;

    }

    //对发放的功能进行说明
    @ApiOperation(value = "批量删除记录")
    //对方法的参数进行说明
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",required = true,paramType = "query",value = "需要删除的多个id，用逗号隔开")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteByIds(String ids){

        Result result = new Result();
        bookService.deleteByIds(ids);
        result.success("删除成功");
        return result;
    }

    @ApiOperation(value = "批量跟新记录的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",required = true,paramType = "query",value = "需要修改的多个id，用逗号隔开"),
            @ApiImplicitParam(name = "userful",required = true,paramType = "query",value = "修改后的状态")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/updateUsefulByIds")
    public Result updateUsefulByIds(String ids,Boolean useful){

        Result result = new Result();
        bookService.updateUsefulByIds(ids,useful);
        result.success("状态跟新成功");
        return result;
    }


    @ApiOperation(value = "返回所有记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",paramType = "query",value = "书名关键字。可用为空"),
            @ApiImplicitParam(name = "priceMin", paramType = "query",value = "价格最小值，可以为空"),
            @ApiImplicitParam(name = "priceMax", paramType = "query",value = "价格最大值，可以为空")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public Result list(String name,Double priceMin, Double priceMax){

        Result result = new Result();
        result.setData(bookService.list(name,priceMin,priceMax));
        result.success("查询成功");
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AllList")
    public Result AllList(){

        Result result = new Result();
        result.setData(bookService.AllList());
        result.success("查询成功");
        return result;
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", required = true, paramType = "query", value = "当前页码"),
            @ApiImplicitParam(name = "pageSize", required = true, paramType = "query", value = "每页显示条数"),
            @ApiImplicitParam(name = "name", paramType = "query", value = "书名关键字，可以为空")
    })
    @ApiOperation(value = "分页返回记录")
    @RequestMapping(method = RequestMethod.POST, value = "/page")
    public Result page(Integer pageNum, Integer pageSize, String name){

        Result result = new Result();

        result.setData(bookService.page(pageNum,pageSize,name));
        result.success("分页查询成功");
        return result;
    }

    @ApiOperation(value = "分页返回所有记录")
    @RequestMapping(method = RequestMethod.POST, value = "/pageList")
    public Result pageList(Integer pageNum, Integer pageSize){

        Result result = new Result();

        result.setData(bookService.pageList(pageNum,pageSize));
        result.success("返回成功");
        return result;
    }
}
