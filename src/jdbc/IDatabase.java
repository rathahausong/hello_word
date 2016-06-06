package jdbc;

import java.util.ArrayList;

public interface IDatabase {
	public abstract boolean insertRow(Object obj) throws Exception;
	public abstract ArrayList<Object> selectRecord() throws Exception;
	public abstract boolean updateRecord(Object obj) throws Exception;
	public abstract boolean deleteRecord(String id) throws Exception;
	public abstract ArrayList<Object> searchRecord(String search) throws Exception;
}
