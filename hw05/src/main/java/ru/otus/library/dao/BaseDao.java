package ru.otus.library.dao;

public abstract class BaseDao {

    public abstract String getTableName();

    public SqlSelectBuilder createSelectBuilder() {
        return new SqlSelectBuilder(getTableName());
    }

    public interface ColumnNameTranslator {
        String translate(String column);
    }

    public static class IdleColumnNameTranslator implements ColumnNameTranslator {

        @Override
        public String translate(String column) {
            return column;
        }
    }

    public static class PrefixAppendTranslator implements ColumnNameTranslator {

        private String prefix;

        public PrefixAppendTranslator(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public String translate(String column) {
            return prefix+column;
        }
    }

    public abstract static class RowMapper<E> implements org.springframework.jdbc.core.RowMapper<E> {
        private ColumnNameTranslator columnNameTranslator;
        RowMapper(ColumnNameTranslator columnNameTranslator) {
            this.columnNameTranslator = columnNameTranslator;
        }

        RowMapper() {
            this(new IdleColumnNameTranslator());
        }

        public ColumnNameTranslator getColumnNameTranslator() {
            return columnNameTranslator;
        }

        public String getColumnId(String column) {
            return getColumnNameTranslator().translate(column);
        }
    }
}
