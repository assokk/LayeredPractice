package org.example.layered.service;

import org.example.layered.dto.MemoRequestDto;
import org.example.layered.dto.MemoResponseDto;
import org.example.layered.entity.Memo;
import org.example.layered.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Annotation @Service는 @Component와 같다, Spring Bean으로 등록한다는 뜻.
 * Spring Bean으로 등록되면 다른 클래스에서 주입하여 사용할 수 있다.
 * 명시적으로 Service Layer 라는것을 나타낸다.
 * 비지니스 로직을 수행한다.
 */
@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    };


    @Override
    public MemoResponseDto saveMemo(MemoRequestDto dto) {

        // 요청받은 데이터로 MEMO 객체 생성 ID 없음 (→ Repository Layer)
        Memo memo = new Memo(dto.getTitle(), dto.getContents());

        // DB 저장
        Memo savedMemo = memoRepository.saveMemo(memo);

        // 생성되고 저장된 memo가 MemoResponseDto 형태로 반환
        return new MemoResponseDto(savedMemo);
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {

        List<MemoResponseDto> allMemos = memoRepository.findAllMemos();

        return allMemos;

        // 또는 바로 반환
        // return memoRepository.findAllMemos();
    }
}
