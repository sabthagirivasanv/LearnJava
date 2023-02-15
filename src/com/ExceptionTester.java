package com;

import com.exception.CustomUncheckedException;

public class ExceptionTester {

    public static void main(String[] args) {
        throw new CustomUncheckedException();
    }
}
