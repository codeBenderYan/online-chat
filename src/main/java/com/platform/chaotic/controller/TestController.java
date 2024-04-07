package com.platform.chaotic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/7 21:05:02
 */
@Tag(name = "项目测试接口")
@RestController
@RequestMapping("/ping")
public class TestController {

    /**
     * 测试项目接口是否调用成功
     *
     * @Api → @Tag
     * @ApiIgnore→@Parameter(hidden = true)或@Operation(hidden = true)或@Hidden
     * @ApiImplicitParam → @Parameter
     * @ApiImplicitParams → @Parameters
     * @ApiModel → @Schema
     * @ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)
     * @ApiModelProperty → @Schema
     * @ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")
     * @ApiParam → @Parameter
     * @ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")
     */
    @Operation(description = "测试接口")
    @RequestMapping(method = RequestMethod.GET)
    @ApiResponse(responseCode = "200", description = "返回success，则表示调用成功。")
    public String testDemo() {
        return "success";
    }
}