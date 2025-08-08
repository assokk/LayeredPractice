package org.example.layered.repository;

import org.example.layered.dto.MemoResponseDto;
import org.example.layered.entity.Memo;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Annotation @Repository는 @Component와 같다, Spring Bean으로 등록한다는 뜻.
 * Spring Bean으로 등록되면 다른 클래스에서 주입하여 사용할 수 있다.
 * 명시적으로 Repository Layer 라는것을 나타낸다.
 * DB와 상호작용하여 데이터를 CRUD하는 작업을 수행한다.
 */
@Repository
public class MemoRepositoryImpl implements MemoRepository {

    // Repository Layer : 실제 DB와 상호작용해서 데이터를 CRUD 하는 역할
    // 데이터베이스(Repository)
    private final Map<Long, Memo> memoList = new HashMap<>();

    @Override
    public Memo saveMemo(Memo memo) {

        // 전달받은 memo 객체에 Id를 세팅
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
        memo.setId(memoId);

        memoList.put(memoId, memo);

        return memo;
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {

        // List 초기화
        List<MemoResponseDto> allMemos = new ArrayList<>();

        for (Memo memo : memoList.values()) {
            MemoResponseDto responseDto = new MemoResponseDto(memo);
            allMemos.add(responseDto);
        }

        return allMemos;
    }

    @Override
    public Memo findMemoById(Long id) {
        return memoList.get(id);
    }

    @Override
    public void deleteMemo(Long id) {
        memoList.remove(id);
    }
}