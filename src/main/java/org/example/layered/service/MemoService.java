package org.example.layered.service;

import org.example.layered.dto.MemoRequestDto;
import org.example.layered.dto.MemoResponseDto;

public interface MemoService {

    MemoResponseDto saveMemo(MemoRequestDto dto);
}
