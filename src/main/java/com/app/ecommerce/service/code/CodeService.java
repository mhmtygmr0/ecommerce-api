package com.app.ecommerce.service.code;

import com.app.ecommerce.entity.Code;
import org.springframework.data.domain.Page;

public interface CodeService {
    Code save(Code code);

    Code get(int id);

    Page<Code> cursor(int page, int size);

    Code update(Code code);

    boolean delete(int id);
}
