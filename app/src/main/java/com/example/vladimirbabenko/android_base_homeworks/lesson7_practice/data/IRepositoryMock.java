package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data;

import java.util.List;

public interface IRepositoryMock <T> {
    List<T> fetchMocks();
}
