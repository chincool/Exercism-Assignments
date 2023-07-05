class CustomCheckedException extends Exception {

    CustomCheckedException() {
        throw new IllegalArgumentException();
    }

    CustomCheckedException(String message) {
        throw new IllegalArgumentException(message);
    }

}
