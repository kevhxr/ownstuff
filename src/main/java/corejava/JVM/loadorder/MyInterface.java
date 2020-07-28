package corejava.JVM.loadorder;

import org.springframework.context.ApplicationContext;

import javax.sql.rowset.JdbcRowSet;

public interface MyInterface extends JdbcRowSet, ApplicationContext {
}
