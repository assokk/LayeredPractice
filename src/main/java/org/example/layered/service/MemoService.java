package org.example.layered.service;

import org.example.layered.dto.MemoRequestDto;
import org.example.layered.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {

    MemoResponseDto saveMemo(MemoRequestDto dto);

    List<MemoResponseDto> findAllMemos();

    MemoResponseDto findMemoById(Long id);
}
