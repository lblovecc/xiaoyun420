package com.xiaoyun.main.mapper;

import com.xiaoyun.main.model.AuthCode;

public interface AuthCodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_code
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_code
     *
     * @mbggenerated
     */
    int insert(AuthCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_code
     *
     * @mbggenerated
     */
    int insertSelective(AuthCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_code
     *
     * @mbggenerated
     */
    AuthCode selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_code
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AuthCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auth_code
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AuthCode record);
}