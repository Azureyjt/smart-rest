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

import com.azureyjt.smartrest.service.CommonRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Entry point of all the user-defined REST API.
 */
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommonRestController {

    private final CommonRestService commonRestService;

    /**
     * Contructor of CommonRestController.
     *
     * @param commonRestService CommonRestService Spring bean.
     */
    @Autowired
    public CommonRestController(CommonRestService commonRestService) {
        this.commonRestService = commonRestService;
    }

    /**
     * Filter GET request.
     *
     * @param request HttpServletRequest.
     * @param response HttpServletResponse
     * @return Response data in JSON format.
     */
    @GetMapping(path = "")
    public String getRequest(HttpServletRequest request,
                             HttpServletResponse response) {
        String responseData = commonRestService.executeGet(request.getRequestURI());
        return responseData;
    }

    /**
     * Filter POST request.
     *
     * @param request HttpServletRequest.
     * @param response HttpServletResponse.
     * @param body Request body data.
     * @return Response data in JSON format.
     */
    @PostMapping(path = "")
    public String postRequest(HttpServletRequest request,
                              HttpServletResponse response,
                              @RequestBody String body) {
        String responseData = commonRestService.executePost(request.getRequestURI(), body);
        return responseData;
    }

    /**
     * Filter PUT request.
     *
     * @param request HttpServletRequest.
     * @param response HttpServletResponse.
     * @param body Request body data.
     * @return Response data in JSON format.
     */
    @PutMapping(path = "")
    public String putRequest(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestBody String body) {
        String responseData = commonRestService.executePut(request.getRequestURI(), body);
        return responseData;
    }

    /**
     * Filter DELETE request.
     * @param request HttpServletRequest.
     * @param response HttpServletResponse.
     * @return Response data in JSON format.
     */
    @DeleteMapping(path = "")
    public String deleteRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        String responseData = commonRestService.executeDelete(request.getRequestURI());
        return responseData;
    }

}
