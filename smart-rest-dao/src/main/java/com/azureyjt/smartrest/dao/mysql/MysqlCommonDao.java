/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.azureyjt.smartrest.dao.mysql;

import com.azureyjt.smartrest.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Mysql common dao class.
 */
@Repository
public class MysqlCommonDao implements CommonDao {

    private final JdbcTemplate jdbcTemplate;

    private String tableName;

    private String idColumnName;

    /**
     * Construct MysqlCommonDao instance. Use Springboot jdbc plguin to generate jdbc
     * bean automatically.
     *
     * @param jdbcTemplate JdbcTemplate
     */
    @Autowired
    public MysqlCommonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Get all records.
     *
     * @return List of the record data. each entity in the list is a map which stored a
     *     tuple of data. Key is the column name and value is the column value.
     */
    @Override
    public List<Map<String, Object>> getAll() {
        String sql = MysqlQueryGenerator.getAllRecordsQuery(this.tableName);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    /**
     * Get the record with specified id.
     *
     * @param id ID of the required record.
     * @return Record data. The data is stored in a map. Key is the column name and value
     *     is the column value.
     */
    public Map<String, Object> getById(Object id) {
        String sql = MysqlQueryGenerator.getRecordByIdQuery(
                this.tableName,
                this.idColumnName,
                id);
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        return result;
    }

    /**
     * Get specified table name in Mysql DB instance.
     *
     * @return Table name.
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Set specified table name in Mysql DB instance.
     *
     * @param tableName Table name.
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Get column name of id.
     *
     * @return Column name.
     */
    public String getIdColumnName() {
        return idColumnName;
    }

    /**
     * Set column name of id.
     *
     * @param idColumnName Column name.
     */
    public void setIdColumnName(String idColumnName) {
        this.idColumnName = idColumnName;
    }
}
