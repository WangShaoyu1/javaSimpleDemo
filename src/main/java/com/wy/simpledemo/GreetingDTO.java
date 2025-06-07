package com.wy.simpledemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel
public class GreetingDTO {
    @ApiModelProperty("ID")
    private long id;

    @NotBlank(message = "内容不能为空")
    @ApiModelProperty("内容")
    private String content;

    public GreetingDTO() {
    }
}