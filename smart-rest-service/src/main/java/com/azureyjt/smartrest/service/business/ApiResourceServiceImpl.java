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

import com.azureyjt.smartrest.common.model.ApiResource;
import com.azureyjt.smartrest.common.utility.JsonUtils;
import com.azureyjt.smartrest.service.ApiResourceService;
import com.azureyjt.smartrest.service.config.CacheProperties;
import com.azureyjt.smartrest.service.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * Implementation class of ApiResourceService.
 */
public class ApiResourceServiceImpl implements ApiResourceService {

    private final CacheManager cacheManager;

    private final CacheProperties cacheProperties;

    @Autowired
    public ApiResourceServiceImpl(CacheManager cacheManager, CacheProperties cacheProperties) {
        this.cacheManager = cacheManager;
        this.cacheProperties = cacheProperties;
    }

    /**
     * Create new REST API resource according to the
     * @param apiResource Api resource entity that need to be created.
     */
    @Override
    public void createApiConfig(final ApiResource apiResource) throws ResourceAlreadyExistsException {
        Cache cache = getApiResourceCache();
        if (cache.get(apiResource.getApiUri()) != null) {
            throw new ResourceAlreadyExistsException();
        }
        cache.put(apiResource.getApiUri(), JsonUtils.toJson(apiResource));
    }

    private Cache getApiResourceCache() {
        return cacheManager.getCache(cacheProperties.getApiMapName());
    }
}
