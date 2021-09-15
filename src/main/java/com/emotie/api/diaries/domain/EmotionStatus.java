package com.emotie.api.diaries.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class EmotionStatus {
    private static final double TRANSFER_WEIGHT = 0.79;
    private static final double REVERSE_TRANSFER_WEIGHT = 1/TRANSFER_WEIGHT;
    private double score;
    private int count;

    public EmotionStatus(double score, int count) {
        this.score = score;
        this.count = count;
    }

    public void addOne() {
        this.count += 1;
    }

    public void removeOne() {
        if (this.count <= 0) throw new IllegalStateException("글이 음수가 될 수는 없습니다.");
        this.count -= 1;
    }

    public void deepenScore(double scoreUpdater) {
        this.score = TRANSFER_WEIGHT * this.score + (1 - TRANSFER_WEIGHT) * scoreUpdater;
    }

    public void reduceScore(double scoreUpdater) {
        this.score = REVERSE_TRANSFER_WEIGHT * this.score + (1 - REVERSE_TRANSFER_WEIGHT) * scoreUpdater;
    }
}
