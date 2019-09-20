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

package com.azureyjt.smartrest.service.business;

import com.azureyjt.smartrest.dao.CommonDao;
import com.azureyjt.smartrest.service.CommonRestService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CommonRestService implementation class.
 */
public class CommonRestServiceImpl implements CommonRestService {

    private final CommonDao commonDao;

    /**
     * Constructor of CommonRestServiceImpl.
     *
     * @param commonDao CommonDao bean.
     */
    @Autowired
    public CommonRestServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * Execute GET request.
     *
     * @param url Request url.
     * @return Response body data.
     */
    @Override
    public String executeGet(String url) {
        return "test";
    }

    /**
     * Execute POST request.
     *
     * @param url  Request url.
     * @param body Request body.
     * @return Response body data.
     */
    @Override
    public String executePost(String url, String body) {
        return null;
    }

    /**
     * Execute PUT request.
     *
     * @param url  Request url.
     * @param body Request body.
     * @return Response body data.
     */
    @Override
    public String executePut(String url, String body) {
        return null;
    }

    /**
     * Execute DELETE request.
     *
     * @param url Request url.
     * @return Response body data.
     */
    @Override
    public String executeDelete(String url) {
        return null;
    }

}
