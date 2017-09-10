package net.jacoblo.data;

import java.util.ArrayList;

public interface UnionFindable {
	public UnionFindable getLeader();
	public boolean setLeader(UnionFindable newLeader);
	public ArrayList<UnionFindable> getChildren();
}
