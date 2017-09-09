package net.jacoblo.data;

public interface UnionFindable {
	public UnionFindable find(UnionFindable current);
	public UnionFindable union(UnionFindable group1, UnionFindable group2);
}
