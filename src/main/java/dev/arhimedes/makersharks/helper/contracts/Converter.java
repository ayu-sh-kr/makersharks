package dev.arhimedes.makersharks.helper.contracts;

public interface Converter<S, T> {

    T convert(S source, T target);

    S revert(T source, S target);

}
