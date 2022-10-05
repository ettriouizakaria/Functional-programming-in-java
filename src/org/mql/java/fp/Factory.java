package org.mql.java.fp;

@FunctionalInterface
public interface Factory<T> {
	public T create(int x, int y);
}
