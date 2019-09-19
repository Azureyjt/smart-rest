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

package com.azureyjt.smartrest.dao;

import java.util.List;
import java.util.Map;

/**
 * CommonDao defines basic CRUD opertaions that should be support in different database
 * products. It does not use generic programming to link the data to defined data model.
 * Instead of that the results of queries are stored in HashMap and then filtered by the
 * rules defined by pre-generated REST API.
 */
public interface CommonDao {

    /**
     * Get all records.
     *
     * @return List of the record data. each entity in the list is a map which stored a
     *      tuple of data. Key is the column name and value is the column value.
     */
    List<Map<String, Object>> getAll();

    /**
     * Get the record with specified id.
     *
     * @param id ID of the required record.
     * @return Record data. The data is stored in a map. Key is the column name and value
     *     is the column value.
     */
    Map<String, Object> getById(Object id);

}
