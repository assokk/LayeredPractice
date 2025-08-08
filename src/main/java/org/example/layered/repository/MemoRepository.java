package org.example.layered.repository;

import org.example.layered.entity.Memo;

public interface MemoRepository {

    // DB에 저장된 결과의 Memo 클래스를 반환받음
    Memo saveMemo(Memo memo);
}
