package com.study.swagger.controller;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static springfox.documentation.swagger.common.HostNameProvider.componentsFrom;

import io.swagger.models.Swagger;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import com.google.common.base.Strings;
import com.study.swagger.config.SwaggerConfig;


@RestController
@RequestMapping
public class SwaggerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerController.class);
    private static final String HAL_MEDIA_TYPE = "application/hal+json";

    private final String hostNameOverride;
    private final DocumentationCache documentationCache;
    private final ServiceModelToSwagger2Mapper mapper;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public SwaggerController(Environment environment, DocumentationCache documentationCache, ServiceModelToSwagger2Mapper mapper, JsonSerializer jsonSerializer) {
        this.hostNameOverride = environment.getProperty("springfox.documentation.swagger.v2.host", "DEFAULT");
        this.documentationCache = documentationCache;
        this.mapper = mapper;
        this.jsonSerializer = jsonSerializer;
    }

    @RequestMapping(value = "/crov/v2/api-docs", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE})
    public ResponseEntity<Json> getDocumentation(HttpServletRequest servletRequest) {
        Documentation documentation = documentationCache.documentationByGroup(SwaggerConfig.CROV_GROUP);
        if (documentation == null) {
            LOGGER.warn("Unable to find specification for group {}", SwaggerConfig.CROV_GROUP);
            return new ResponseEntity<Json>(HttpStatus.NOT_FOUND);
        }
        Swagger swagger = mapper.mapDocumentation(documentation);
        UriComponents uriComponents = componentsFrom(servletRequest, swagger.getBasePath());
        swagger.basePath(Strings.isNullOrEmpty(uriComponents.getPath()) ? "/" : uriComponents.getPath());
        if (isNullOrEmpty(swagger.getHost())) {
            swagger.host(hostName(uriComponents));
        }
        return new ResponseEntity<Json>(jsonSerializer.toJson(swagger), HttpStatus.OK);
    }

    @RequestMapping(value = "/doba/v2/api-docs", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE})
    public ResponseEntity<Json> getDocumentation2(
            HttpServletRequest servletRequest) {
        Documentation documentation = documentationCache.documentationByGroup(SwaggerConfig.DOBA_GROUP);
        if (documentation == null) {
            LOGGER.warn("Unable to find specification for group {}", SwaggerConfig.DOBA_GROUP);
            return new ResponseEntity<Json>(HttpStatus.NOT_FOUND);
        }
        Swagger swagger = mapper.mapDocumentation(documentation);
        UriComponents uriComponents = componentsFrom(servletRequest, swagger.getBasePath());
        swagger.basePath(Strings.isNullOrEmpty(uriComponents.getPath()) ? "/" : uriComponents.getPath());
        if (isNullOrEmpty(swagger.getHost())) {
            swagger.host(hostName(uriComponents));
        }
        return new ResponseEntity<Json>(jsonSerializer.toJson(swagger), HttpStatus.OK);
    }


    @RequestMapping(value = "/mic/v2/api-docs", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE})
    public ResponseEntity<Json> getDocumentation3(
            HttpServletRequest servletRequest) {
        Documentation documentation = documentationCache.documentationByGroup(SwaggerConfig.MIC_GROUP);
        if (documentation == null) {
            LOGGER.warn("Unable to find specification for group {}", SwaggerConfig.MIC_GROUP);
            return new ResponseEntity<Json>(HttpStatus.NOT_FOUND);
        }
        Swagger swagger = mapper.mapDocumentation(documentation);
        UriComponents uriComponents = componentsFrom(servletRequest, swagger.getBasePath());
        swagger.basePath(Strings.isNullOrEmpty(uriComponents.getPath()) ? "/" : uriComponents.getPath());
        if (isNullOrEmpty(swagger.getHost())) {
            swagger.host(hostName(uriComponents));
        }
        return new ResponseEntity<Json>(jsonSerializer.toJson(swagger), HttpStatus.OK);
    }


    private String hostName(UriComponents uriComponents) {
        if ("DEFAULT".equals(hostNameOverride)) {
            String host = uriComponents.getHost();
            int port = uriComponents.getPort();
            if (port > -1) {
                return String.format("%s:%d", host, port);
            }
            return host;
        }
        return hostNameOverride;
    }
}
