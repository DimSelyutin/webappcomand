package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IConnectionDAO;
import by.htp.ex.dao.connectionpool.ConnectionPoolException;
import by.htp.ex.dao.connectionpool.Logger;
import java.lang.System.Logger.Level;
import by.htp.ex.dao.connectionpool.PoolConnection;

public class ConnectionDAO implements IConnectionDAO{

    private PoolConnection poolConnection;
    private Connection connection;
    private Logger logger;
    private Level lvl;


    
    public ConnectionDAO() {
        this.poolConnection = new PoolConnection();
        try {
            poolConnection.initPoolData();
        } catch (ConnectionPoolException e) {
            logger.log(lvl.ERROR, "Error to init pooldata!", e);
        }
    }
    
    public Connection getConnection() throws DaoException {
        try {
            connection = poolConnection.takeConnection();
        } catch (ConnectionPoolException e) {
            throw new DaoException("");
        }
        return connection;
    }


    @Override
    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        
            poolConnection.closeConnection(connection, st, rs);
        
       
        
    }

    @Override
    public void closeConnection(Connection con, Statement st) {
        poolConnection.closeConnection(con, st);
        
    }

    



    
    
}
