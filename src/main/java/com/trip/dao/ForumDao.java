package com.trip.dao;

import com.trip.domain.Forum;
import com.trip.domain.ForumExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer tpFid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    int insert(Forum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    int insertSelective(Forum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    List<Forum> selectByExampleWithBLOBs(ForumExample example);

    List<Forum> forumPointSearch(Forum forum);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    List<Forum> selectByExample(ForumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    Forum selectByPrimaryKey(Integer tpFid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Forum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Forum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_forum
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Forum record);
}