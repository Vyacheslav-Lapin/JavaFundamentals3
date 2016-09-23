import lombok.SneakyThrows;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Supplier;

//1. "^\s{4}([^ @v]([<\w, \?>])* ([^(]+)\(([^)]*)\)( throws [\w,]+)?);"
//1. "    default $1 {\n        return get().$3($4);\n    }"
//2. "^\s{4}(void ([^(]+)\(([^)]*)\)( throws [\w,]+)?);"
//2. "    default $1 {\n        get().$2($3);\n    }"
//3. "(get\(\)\.[^(]+)\([\w]+ ([^),]+.*)\)"
//3. "$1($2)"
public interface PooledConnection extends Connection, Supplier<Connection> {

    @SneakyThrows
    static PooledConnection create(Connection connection, Consumer<PooledConnection> free) {

        connection.setAutoCommit(true);

        return new PooledConnection() {
            @Override
            public Connection get() {
                return connection;
            }

            @Override
            public void close() throws SQLException {
                free.accept(this);
            }
        };
    }

    @SneakyThrows
    static PooledConnection create(Connection connection, BlockingQueue<PooledConnection> connectionFreeBlockingQueue) {
        return create(connection, connectionFreeBlockingQueue::offer);
    }

    default void reallyClose() throws SQLException {
        get().close();
    }

    @Override
    default Statement createStatement() throws SQLException {
        return get().createStatement();
    }

    @Override
    default PreparedStatement prepareStatement(String sql) throws SQLException {
        return get().prepareStatement(sql);
    }

    @Override
    default CallableStatement prepareCall(String sql) throws SQLException {
        return get().prepareCall(sql);
    }

    @Override
    default String nativeSQL(String sql) throws SQLException {
        return get().nativeSQL(sql);
    }

    @Override
    default void setAutoCommit(boolean autoCommit) throws SQLException {
        get().setAutoCommit(autoCommit);
    }

    @Override
    default boolean getAutoCommit() throws SQLException {
        return get().getAutoCommit();
    }

    @Override
    default void commit() throws SQLException {
        get().commit();
    }

    @Override
    default void rollback() throws SQLException {
        get().rollback();
    }

    @Override
    default boolean isClosed() throws SQLException {
        return get().isClosed();
    }

    @Override
    default DatabaseMetaData getMetaData() throws SQLException {
        return get().getMetaData();
    }

    @Override
    default void setReadOnly(boolean readOnly) throws SQLException {
        get().setReadOnly(readOnly);
    }

    @Override
    default boolean isReadOnly() throws SQLException {
        return get().isReadOnly();
    }

    @Override
    default void setCatalog(String catalog) throws SQLException {
        get().setCatalog(catalog);
    }

    @Override
    default String getCatalog() throws SQLException {
        return get().getCatalog();
    }

    @Override
    default void setTransactionIsolation(int level) throws SQLException {
        get().setTransactionIsolation(level);
    }

    @Override
    default int getTransactionIsolation() throws SQLException {
        return get().getTransactionIsolation();
    }

    @Override
    default SQLWarning getWarnings() throws SQLException {
        return get().getWarnings();
    }

    @Override
    default void clearWarnings() throws SQLException {
        get().clearWarnings();
    }

    @Override
    default Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return get().createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return get().prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    default CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return get().prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    default Map<String, Class<?>> getTypeMap() throws SQLException {
        return get().getTypeMap();
    }

    @Override
    default void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        get().setTypeMap(map);
    }

    @Override
    default void setHoldability(int holdability) throws SQLException {
        get().setHoldability(holdability);
    }

    @Override
    default int getHoldability() throws SQLException {
        return get().getHoldability();
    }

    @Override
    default Savepoint setSavepoint() throws SQLException {
        return get().setSavepoint();
    }

    @Override
    default Savepoint setSavepoint(String name) throws SQLException {
        return get().setSavepoint(name);
    }

    @Override
    default void rollback(Savepoint savepoint) throws SQLException {
        get().rollback(savepoint);
    }

    @Override
    default void releaseSavepoint(Savepoint savepoint) throws SQLException {
        get().releaseSavepoint(savepoint);
    }

    @Override
    default Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return get().createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return get().prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    default CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return get().prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return get().prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return get().prepareStatement(sql, columnIndexes);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return get().prepareStatement(sql, columnNames);
    }

    @Override
    default Clob createClob() throws SQLException {
        return get().createClob();
    }

    @Override
    default Blob createBlob() throws SQLException {
        return get().createBlob();
    }

    @Override
    default NClob createNClob() throws SQLException {
        return get().createNClob();
    }

    @Override
    default SQLXML createSQLXML() throws SQLException {
        return get().createSQLXML();
    }

    @Override
    default boolean isValid(int timeout) throws SQLException {
        return get().isValid(timeout);
    }

    @Override
    default void setClientInfo(String name, String value) throws SQLClientInfoException {
        get().setClientInfo(name, value);
    }

    @Override
    default void setClientInfo(Properties properties) throws SQLClientInfoException {
        get().setClientInfo(properties);
    }

    @Override
    default String getClientInfo(String name) throws SQLException {
        return get().getClientInfo(name);
    }

    @Override
    default Properties getClientInfo() throws SQLException {
        return get().getClientInfo();
    }

    @Override
    default Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return get().createArrayOf(typeName, elements);
    }

    @Override
    default Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return get().createStruct(typeName, attributes);
    }

    @Override
    default void setSchema(String schema) throws SQLException {
        get().setSchema(schema);
    }

    @Override
    default String getSchema() throws SQLException {
        return get().getSchema();
    }

    @Override
    default void abort(Executor executor) throws SQLException {
        get().abort(executor);
    }

    @Override
    default void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        get().setNetworkTimeout(executor, milliseconds);
    }

    @Override
    default int getNetworkTimeout() throws SQLException {
        return get().getNetworkTimeout();
    }

    @Override
    default <T> T unwrap(Class<T> iface) throws SQLException {
        return get().unwrap(iface);
    }

    @Override
    default boolean isWrapperFor(Class<?> iface) throws SQLException {
        return get().isWrapperFor(iface);
    }
}