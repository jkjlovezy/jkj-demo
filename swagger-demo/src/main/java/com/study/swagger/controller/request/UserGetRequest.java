package com.study.swagger.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserGetRequest {
    @ApiModelProperty(value = "会员ID", example = "1")
    private Integer id;
}
