<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">
<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>
</#if>

    <sql id="mapWhereClause">
        <#list table.fields as field>
        <#if !field.keyFlag><#--生成普通字段 -->
        <if test="param.${field.name} != null and '' != param.${field.name}"> and tb.${field.name} = #${"\{"}param.${field.propertyName}}</if>
        </#if>
        </#list>
    </sql>

    <select id="pageQuery" parameterType="java.util.Map" resultType="${package.Entity}.${entity}">
        select
        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
            tb.${field.name} as ${field.propertyName},
            </#if>
        </#list>
        <include refid="BaseMapper.getListClause"></include>
        from ${table.name} tb where tb.status = '1'
        <include refid="mapWhereClause"></include>
    </select>

    <delete id="batchDelete" parameterType="java.util.List">
        delete from ${table.name} where id in
        <foreach collection="list" item="id" open="(" separator="," close=")">
            #${"\{"}id}
        </foreach>
    </delete>

    <update id="remove" parameterType="${package.Entity}.${entity}">
        update ${table.name} set
        updatedate = #${"\{"}updateDate},
        updatetime = #${"\{"}updateTime},
        status = #${"\{"}status}
            where id = #${"\{"}id}
    </update>
</mapper>
