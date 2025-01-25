package com.app.ecommerce.controller;

import com.app.ecommerce.core.config.modelMapper.ModelMapperService;
import com.app.ecommerce.core.result.Result;
import com.app.ecommerce.core.result.ResultData;
import com.app.ecommerce.core.utilies.ResultHelper;
import com.app.ecommerce.dto.request.code.CodeSaveRequest;
import com.app.ecommerce.dto.request.code.CodeUpdateRequest;
import com.app.ecommerce.dto.response.CodeResponse;
import com.app.ecommerce.dto.response.CursorResponse;
import com.app.ecommerce.entity.Code;
import com.app.ecommerce.service.code.CodeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class CodeController {

    private final CodeService codeService;
    private final ModelMapperService modelMapper;

    public CodeController(CodeService codeService, ModelMapperService modelMapper) {
        this.codeService = codeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CodeResponse> save(@Valid @RequestBody CodeSaveRequest codeSaveRequest) {
        Code code = this.modelMapper.forRequest().map(codeSaveRequest, Code.class);
        this.codeService.save(code);
        return ResultHelper.created(this.modelMapper.forResponse().map(code, CodeResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CodeResponse> get(@PathVariable("id") int id) {
        Code code = this.codeService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(code, CodeResponse.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CodeResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Code> codePage = this.codeService.cursor(page, pageSize);
        Page<CodeResponse> codeResponsePage = codePage.map(code -> this.modelMapper.forResponse().map(code, CodeResponse.class));
        return ResultHelper.cursor(codeResponsePage);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CodeResponse> update(@Valid @RequestBody CodeUpdateRequest codeUpdateRequest) {
        Code code = this.modelMapper.forRequest().map(codeUpdateRequest, Code.class);
        this.codeService.update(code);
        return ResultHelper.success(this.modelMapper.forResponse().map(code, CodeResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.codeService.delete(id);
        return ResultHelper.ok();
    }
}
