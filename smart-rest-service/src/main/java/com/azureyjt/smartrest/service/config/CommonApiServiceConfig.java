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

package com.azureyjt.smartrest.service.config;

import com.azureyjt.smartrest.dao.CommonDao;
import com.azureyjt.smartrest.service.business.CommonApiServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Generate Spring bean for CommonApiServiceImpl
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class CommonApiServiceConfig {

    /**
     * Generate CommonApiServiceImpl bean.
     *
     * @param commonDao CommonDao bean. Injected by Spring Java Config.
     * @return CommonApiServiceImpl Spring bean.
     */
    @Bean
    public CommonApiServiceImpl createCommonRestService(
            final CommonDao commonDao,
            final CacheManager cacheManager,
            final CacheProperties cacheProperties) {
        return new CommonApiServiceImpl(
                commonDao,
                cacheManager,
                cacheProperties);
    }
}
