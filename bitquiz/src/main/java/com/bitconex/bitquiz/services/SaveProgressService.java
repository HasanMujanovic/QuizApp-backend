package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddQuizProgressDto;

public interface SaveProgressService {
    void saveProgress(AddQuizProgressDto addQuizProgressDto);

}
