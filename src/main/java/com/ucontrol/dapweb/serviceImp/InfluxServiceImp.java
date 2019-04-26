package com.ucontrol.dapweb.serviceImp;import com.ucontrol.dapweb.dao.influxdao.InfluxDao;import com.ucontrol.dapweb.entity.Point;import com.ucontrol.dapweb.service.InfluxService;import org.influxdb.dto.QueryResult;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;import java.util.ListIterator;@Service("InfluxService")public class InfluxServiceImp implements InfluxService {    InfluxDao influxdao = new InfluxDao();    @Override    public boolean ping() {        return influxdao.ping();    }    @Override    public ArrayList<Point> getPointByName(String name) {        QueryResult result = influxdao.getPointByName(name);        List<QueryResult.Series> series = result.getResults().get(0).getSeries();        List<List<Object>> values = series.get(0).getValues();        ArrayList<Point> points = new ArrayList<Point>();        ListIterator<List<Object>> listite = values.listIterator();        while (listite.hasNext()){            List<Object> value = listite.next();            String influxTime = value.get(0).toString();            String influxQuality = value.get(1).toString();            Double influxValue = (Double) value.get(2);            Point point = new Point(influxTime, influxQuality, influxValue);            points.add(point);        }        return points;    }}