package ru.otus.library.dao;

import java.util.*;
import java.util.stream.Collectors;

public class SqlSelectBuilder {

    private String tableName;
    private Set<String> wheres = new LinkedHashSet<>();
    private List<String> joins = new ArrayList<>();
    private String alias;
    private int limit = 0;
    private String select;

    public SqlSelectBuilder(String tableName) {
        this.tableName = tableName;
    }

    public SqlSelectBuilder useAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public SqlSelectBuilder join(String join) {
        joins.add(join);
        return this;
    }

    public SqlSelectBuilder useFilterFields(Collection<String> fields) {
        if (fields.size() > 0) {
            wheres.add(getFilterString(fields));
        }
        return this;
    }

    public SqlSelectBuilder useFilterFields(String... fields) {
        useFilterFields(Arrays.asList(fields));
        return this;
    }

    public SqlSelectBuilder limit(int value) {
        limit = value;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("select ");

        sb.append(Objects.requireNonNullElse(select, " * "));

        sb.append(" from `").append(tableName).append("`");

        if (alias != null) {
            sb.append(" ").append(alias).append(" ");
        }
        if (joins.size() > 0) {
            joins.forEach(s -> sb.append(" ").append(s).append(" "));
        }
        if (wheres.size() > 0) {
            sb.append(" where ");
            sb.append(String.join(" and ", wheres));
        }
        if (limit != 0) {
            sb.append(" limit ").append(limit);
        }
        return String.join(" ", sb.toString().split("\\s+"));
    }

    private String getFilterString(Collection<String> fields) {
        return fields.stream()
                .map((field) -> field + " = :" + field)
                .collect(Collectors.joining(" and "));
    }

    public SqlSelectBuilder select(String s) {
        select = s;
        return this;
    }

    public SqlSelectBuilder addWhere(String s) {
        wheres.add(s);
        return this;
    }
}
