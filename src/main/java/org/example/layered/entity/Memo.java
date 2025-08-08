package org.example.layered.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.layered.dto.MemoRequestDto;

    @Getter
    @AllArgsConstructor
    public class Memo {

        @Setter
        private Long id;
        private String title;
        private String contents;

        public Memo(String title, String contents) {
            this.title = title;
            this.contents = contents;
        }

        public void update(String title, String contents) {
            this.title = title;
            this.contents = contents;
        }

        public void updateTitle(String title) {
            this.title = title;
        }
    }