package org.example.layered.controller;

import org.example.layered.dto.MemoRequestDto;
import org.example.layered.dto.MemoResponseDto;
import org.example.layered.entity.Memo;
import org.example.layered.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


    @RestController
    @RequestMapping("/memos")
    public class MemoController {

        // 주입된 의존성을 변경할 수 없어 객체의 상태를 안전하게 유지할 수 있다.
        private final MemoService memoService;

        /**
         * 생성자 주입
         * 클래스가 필요로 하는 의존성을 생성자를 통해 전달하는 방식
         * @param memoService @Service로 등록된 MemoService 구현체인 Impl
         */
        public MemoController(MemoService memoService) {
            this.memoService = memoService;
        }

        /**
         * 메모 생성 API
         * @param : {@link MemoRequestDto} 메모 생성 요청 객체
         * @return : {@link ResponseEntity<MemoResponseDto>} JSON 응답
         */
        // 1. 요청(Controller)
        @PostMapping
        public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto dto) {

            // Service Layer 호출, 응답
            return new ResponseEntity<>(memoService.saveMemo(dto), HttpStatus.CREATED);
        }
    }
