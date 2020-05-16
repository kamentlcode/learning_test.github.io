package com.graduation.novelweb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.dto.Bookrack;
import com.graduation.novelweb.dto.BoorackNovelRel;
import com.graduation.novelweb.mapper.BookrackMapper;
import com.graduation.novelweb.mapper.BoorackNovelRelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 收藏书架业务处理层
 * @author tanlin
 * @date 2020/5/8
 */
@Service
public class BookrackService {
    @Autowired
    private BookrackMapper bookrackMapper;
    @Autowired
    private BoorackNovelRelMapper boorackNovelRelMapper;

    /**
     * 1新建一个书架bid uid bname
     * 2,书架添加书本rid bid nid uid
     */
    public Integer add(Bookrack bookrack){
        Date now = new Date();
        bookrack.setbId(Integer.valueOf(String.valueOf(now.getTime()).substring(0, 10)));
        bookrack.setCreateTime(now);
        bookrack.setUpdateTime(now);

        return bookrackMapper.insert(bookrack);
    }

    public Integer addRef(BoorackNovelRel ref){
        Date now = new Date();
        ref.setRelId(Integer.valueOf(String.valueOf(now.getTime()).substring(0, 10)));
        ref.setCreateTime(now);
        ref.setUpdateTime(now);
        return boorackNovelRelMapper.insert(ref);
    }

    public PageInfo<Bookrack> page(PageInfo<Bookrack> page, Integer uId,String name){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Bookrack> bookracks = bookrackMapper.pageList(uId, name);

        page =((Page<Bookrack>)bookracks).toPageInfo();

        return page;
    }

}
