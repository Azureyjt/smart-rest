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

package com.azureyjt.smartrest.controller;

import com.azureyjt.smartrest.common.model.ApiResource;
import com.azureyjt.smartrest.common.model.ErrorResponse;
import com.azureyjt.smartrest.service.ApiResourceService;
import com.azureyjt.smartrest.service.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Entry point to create / update / delete API resource.
 */
@RestController
@RequestMapping(path = "/resource", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiResourceController {

    private final ApiResourceService apiResourceService;

    /**
     * Constructor of ApiResourceController.
     *
     * @param apiResourceService ApiResourceService Spring bean.
     */
    @Autowired
    public ApiResourceController(ApiResourceService apiResourceService) {
        this.apiResourceService = apiResourceService;
    }

    /**
     * Create Api resource.
     *
     * @param apiResource Request body. Api resource configuration that need to be
     *                    created.
     * @return Response in JSON format.
     */
    @PostMapping(path = "")
    public ResponseEntity<Object> createApiResource(@RequestBody ApiResource apiResource) {
        try {
            apiResourceService.createApiConfig(apiResource);
            return new ResponseEntity<>(apiResource, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
