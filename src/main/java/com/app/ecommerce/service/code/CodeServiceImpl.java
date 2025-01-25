package com.app.ecommerce.service.code;

import com.app.ecommerce.core.exception.NotFoundException;
import com.app.ecommerce.core.utilies.Msg;
import com.app.ecommerce.entity.Code;
import com.app.ecommerce.repository.CodeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;

    public CodeServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    public Code save(Code code) {
        // prefix'i büyük harflere dönüştür
        String uppercasePrefix = code.getPrefix().toUpperCase();
        code.setPrefix(uppercasePrefix);
        return this.codeRepository.save(code);
    }

    @Override
    public Code get(int id) {
        return this.codeRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Code> cursor(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.codeRepository.findAll(pageable);
    }

    @Override
    public Code update(Code code) {
        this.get(code.getId());
        return this.codeRepository.save(code);
    }

    @Override
    public boolean delete(int id) {
        Code code = this.get(id);
        this.codeRepository.delete(code);
        return true;
    }
}
