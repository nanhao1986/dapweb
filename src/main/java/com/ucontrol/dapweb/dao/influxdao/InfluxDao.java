package com.ucontrol.dapweb.dao.influxdao;import com.ucontrol.dapweb.utils.influxdb.InfluxDBConnection;import org.influxdb.dto.QueryResult;public class InfluxDao {    String username = "~";    String password = "~";    String url = "http://192.168.0.100:8086";    String database = "dap_base";    String retentionPolicy = "autogen";    InfluxDBConnection getConnection(){        InfluxDBConnection connection = new InfluxDBConnection(username,password,url,database,retentionPolicy);        return  connection;    }    public boolean ping(){        InfluxDBConnection connection = getConnection();        boolean ping = connection.ping();        connection.close();        return ping;    }    public QueryResult getPointByName(String name){        String command = "SELECT * FROM \"" + name + "\" WHERE time > now() - 72h";        InfluxDBConnection connection = getConnection();        QueryResult result = connection.query(command);        connection.close();        return result;    }}