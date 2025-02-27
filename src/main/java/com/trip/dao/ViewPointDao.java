package com.trip.dao;

import com.trip.domain.Reply;
import com.trip.domain.ViewPoint;
import com.trip.domain.ViewPointExample;
import com.trip.domain.Words;

import java.util.List;

public interface ViewPointDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer tpVid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int insert(ViewPoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int insertSelective(ViewPoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    List<ViewPoint> selectByExampleWithBLOBs(ViewPointExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    List<ViewPoint> selectByExample(ViewPointExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    ViewPoint selectByPrimaryKey(Integer tpVid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ViewPoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    List<ViewPoint> viewPointSearch(ViewPoint viewPoint);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(ViewPoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ViewPoint record);

    /**
     * 保存回复
     * @param words
     * @return
     */
    void saveWords(Words words);

    /**
     * 保存回复信息
     * @param reply
     */
    void saveReply(Reply reply);

    /**
     * 查询所有留言信息
     * @return
     */
    List<Words> findByWords();

    /**
     * 	查询所有回复信息
     */
    List<Reply> findByReply();

}