package com.graduation.novelweb.util.pagehelper;

import com.github.pagehelper.PageInfo;

/**
 * @author tanlin
 * @date 2020/4/24
 */
public class PageUtil {

    /**
     * 默认分页大小.
     */
    public static final int DEFAULT_PAGE_SIZE = 20;
    /**
     * 首页的页码.
     */
    public static final int FIRST_PAGE_NUM = 1;

    /**
     * 创建一个分页对象.
     *
     * 如果参数为空,则生成默认参数.
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static PageInfo createPageInfo(Integer pageNum, Integer pageSize) {
        return createPageInfo(pageNum, pageSize, Object.class);
    }

    /**
     * 创建一个分页对象.
     *
     * 如果参数为空,则生成默认参数.
     *
     * @param <T> 行对象类.
     * @param pageNum
     * @param pageSize
     * @param rowClass 行对象类.
     * @return
     */
    public static <T extends Object> PageInfo<T> createPageInfo(Integer pageNum, Integer pageSize, Class<T> rowClass) {
        if (pageNum == null || pageNum < 1) {
            pageNum = FIRST_PAGE_NUM;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        PageInfo<T> page = new PageInfo<>();
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);
        return page;
    }

    private PageUtil() {
    }

//    /**
//     * 将{@linkplain PageInfo }对象转为
//     * {@linkplain BusinessPageResult}
//     *
//     * @param <T>
//     * @param pageInfo
//     * @return
//     */
//    public static <T extends Object> BusinessPageResult<T> toPageResult(PageInfo<T> pageInfo) {
//        return BusinessPageResult.build(pageInfo.getList(),
//                new BusinessPageInfo(pageInfo.getPageNum(),
//                        pageInfo.getPageSize()), pageInfo.getTotal());
//    }

}
