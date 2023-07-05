class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException() {
        throw new ArithmeticException();
    }

    CustomUncheckedException(String message) {
        throw new ArithmeticException(message);
    }

}
