package com.example.vladimirbabenko.android_base_homeworks.lesson8.data;

import java.util.List;

/**
 * Created by VladimirBabenko on 3/8/2018.
 */

public interface IRepositoryMock<T> {
    List<T> fetchMocks();
}
