package org.example.layered.repository;

import org.example.layered.dto.MemoResponseDto;
import org.example.layered.entity.Memo;

import java.util.List;

public interface MemoRepository {

    // DB에 저장된 결과의 Memo 클래스를 반환받음
    Memo saveMemo(Memo memo);

    List<MemoResponseDto> findAllMemos();

    Memo findMemoById(Long id);
}
